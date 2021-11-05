package com.m4u.estude;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "com.m4u.estude.model")

@SpringBootApplication
public class EstudeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstudeApplication.class, args);
	}

}
