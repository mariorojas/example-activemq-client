package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class ExampleMessagesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleMessagesApplication.class, args);
	}
}
