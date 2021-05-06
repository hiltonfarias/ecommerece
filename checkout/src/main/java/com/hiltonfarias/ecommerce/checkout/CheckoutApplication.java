package com.hiltonfarias.ecommerce.checkout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class CheckoutApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckoutApplication.class, args);
	}

}
