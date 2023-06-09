package com.sy.rest_api_example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Rest_api_exampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(Rest_api_exampleApplication.class, args);
	}

}
