package com.internship.accesa.fooddeliveryauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
@EnableAsync
public class FoodDeliveryAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodDeliveryAuthServerApplication.class, args);
	}

}
