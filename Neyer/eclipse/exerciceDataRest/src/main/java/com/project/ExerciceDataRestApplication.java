package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan
public class ExerciceDataRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExerciceDataRestApplication.class, args);
	}
}
