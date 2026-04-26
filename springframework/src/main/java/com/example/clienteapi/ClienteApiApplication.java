package com.example.clienteapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = "com.example")
@EnableMongoRepositories(basePackages = "com.example")
public class ClienteApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClienteApiApplication.class, args);
	}

}
