package com.cube.assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootAssignment {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootAssignment.class, args);
	}
}
