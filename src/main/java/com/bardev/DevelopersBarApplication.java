package com.bardev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DevelopersBarApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevelopersBarApplication.class, args);
	}

}
