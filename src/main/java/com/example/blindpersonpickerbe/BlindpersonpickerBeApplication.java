package com.example.blindpersonpickerbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class BlindpersonpickerBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlindpersonpickerBeApplication.class, args);
	}

}
