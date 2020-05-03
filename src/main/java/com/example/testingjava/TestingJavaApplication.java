package com.example.testingjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.testingjava")
@EntityScan("com.example.testingjava")
public class TestingJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestingJavaApplication.class, args);
	}

}
