package com.spring.logLearning;

import Service.LogService;
import Service.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.spring.logLearning", "Service"})
public class LogLearningApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext =  SpringApplication.run(LogLearningApplication.class, args);
		System.out.println("Hello World");

		MyService myService = applicationContext.getBean(MyService.class);
		myService.performAction();

		LogService logService = applicationContext.getBean(LogService.class);
		logService.performLogAction();
	}
}
