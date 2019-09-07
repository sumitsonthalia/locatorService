package com.learning.pglocator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class PglocatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PglocatorApplication.class, args);
	}

}
