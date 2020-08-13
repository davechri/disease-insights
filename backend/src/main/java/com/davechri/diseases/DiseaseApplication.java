package com.davechri.diseases;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude=MongoAutoConfiguration.class)
public class DiseaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiseaseApplication.class, args);
	}

}
