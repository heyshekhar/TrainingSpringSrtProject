package com.eci.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class MySpringSrtTrnngProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringSrtTrnngProjectApplication.class, args);
	}

}