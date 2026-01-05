package com.oxentepass.oxentepass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OxentepassApplication {

	public static void main(String[] args) {
		SpringApplication.run(OxentepassApplication.class, args);
	}

}
