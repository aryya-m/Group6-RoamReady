package com.csis3275;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.csis3275.model.ServiceDao;


@SpringBootApplication
public class Group6RoamReadyApplication {

	public static void main(String[] args) {
		SpringApplication.run(Group6RoamReadyApplication.class, args);
	}
	
	// @Bean
	// CommandLineRunner populateDb(ServiceDao repo) {
		
	// 	return ( args ) -> {
	// 		repo.registerUser("admin", "admin", "admin@roamready.ca");
	// 	};
	// }
}
