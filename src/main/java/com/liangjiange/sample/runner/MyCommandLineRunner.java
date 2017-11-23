package com.liangjiange.sample.runner;

import com.liangjiange.sample.config.SystemConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(MyCommandLineRunner.class);

    @Autowired
    private SystemConfig systemConfig;

    @Override
    public void run(String... strings) throws Exception {

        logger.info("~~~~~~~~~~~~~CommandLineRunner start~~~~~~~~~~~~~~");

    }

}
