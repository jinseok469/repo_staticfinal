package com.staticfinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication (exclude = SecurityAutoConfiguration.class)
public class StaticfinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaticfinalApplication.class, args);
	}

}
