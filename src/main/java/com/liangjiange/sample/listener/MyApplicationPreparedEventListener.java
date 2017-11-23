package com.liangjiange.sample.listener;

import com.liangjiange.sample.config.SystemConfig;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class MyApplicationPreparedEventListener implements ApplicationListener<ApplicationPreparedEvent> {

    private Logger logger = LoggerFactory.getLogger(MyApplicationPreparedEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent applicationPreparedEvent) {
        logger.info("~~~~~~~~~~~applicationPreparedEvent~~~~~~~~~~~~~~");
        Config config = ConfigFactory.load();
        String driverClassName = "";
        String tempUrl = "";
        String username = "";
        String password = "";
        try{
            driverClassName = config.getString("spring.datasource.driver-class-name");
            tempUrl = config.getString("spring.datasource.url");
            username = config.getString("spring.datasource.username");
            password = config.getString("spring.datasource.password");
        }catch (ConfigException e){
            logger.error("getLocalizedMessage="+e.getLocalizedMessage());
        }
        if(!"".equalsIgnoreCase(driverClassName) && !"".equalsIgnoreCase(tempUrl) && !"".equalsIgnoreCase(username) && !"".equalsIgnoreCase(password)){
            String[] tempUrlStrings = tempUrl.split("\\?");
            String urlWithDBName = tempUrlStrings[0];
            int lastIndex = urlWithDBName.lastIndexOf("/");
            String url = urlWithDBName.substring(0,lastIndex+1);
            String databaseName = urlWithDBName.substring(lastIndex+1);
            createDatabaseIfNotExist(driverClassName, url, username, password, databaseName);
        }
    }

    /**
     * 若数据库不存在则创建数据库
     *
     * @param driverClassName
     * @param url
     * @param username
     * @param password
     * @param databaseName
     */
    private void createDatabaseIfNotExist(String driverClassName, String url, String username, String password, String databaseName) {
        logger.info("Create Database If Not Exist Start......");
        Connection conn = null;
        Statement stmt = null;
        try {
            //Register JDBC driver
            Class.forName(driverClassName);

            //Open a connection
            logger.info("Connecting to database...");
            conn = DriverManager.getConnection(url, username, password);

            //Execute a query
            System.out.println("Creating database...");
            stmt = conn.createStatement();
            String sql = "create database if not exists " + databaseName;
            stmt.executeUpdate(sql);
            logger.info("Database created successfully...");
        } catch (SQLException se) {
            logger.error("SQLException="+se.getLocalizedMessage());
        } catch (Exception e) {
            logger.error("Exception="+e.getLocalizedMessage());
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                logger.error("Close stmt SQLException="+se2.getLocalizedMessage());
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                logger.error("close Connection SQLException="+se.getLocalizedMessage());
            }//end finally try
        }//end try
        logger.info("Create Database If Not Exist Finish, Goodbye......");
    }
}
