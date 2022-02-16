package com.fender.authorizeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.fender.authorizeservice")
@SpringBootApplication
public class AuthorizeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorizeServiceApplication.class, args);
	}

}
