package com.liangjiange.sample;

import com.liangjiange.sample.listener.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleJpaMysqlApplication {

	public static void main(String[] args) throws Exception {

		SpringApplication app = new SpringApplication(SampleJpaMysqlApplication.class);
		app.addListeners(new MyApplicationStartingEventListener());
        app.addListeners(new MyApplicationEnvironmentPreparedEventListener());
        app.addListeners(new MyApplicationPreparedEventListener());
        app.addListeners(new MyApplicationFailedEventListener());
        app.addListeners(new MyApplicationReadyEventListener());
        app.run(args);
	}

}
