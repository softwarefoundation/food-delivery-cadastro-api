package com.softwarefoundation.fooddeliverycadastroapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class FoodDeliveryCadastroApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodDeliveryCadastroApiApplication.class, args);
	}

}
