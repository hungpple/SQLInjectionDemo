package com.example.SQLInjectionDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
public class SqlInjectionDemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SqlInjectionDemoApplication.class, args);
	}

}