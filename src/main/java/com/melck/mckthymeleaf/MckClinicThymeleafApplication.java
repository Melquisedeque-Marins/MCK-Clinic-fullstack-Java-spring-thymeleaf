package com.melck.mckthymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MckClinicThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(MckClinicThymeleafApplication.class, args);
	}

}
