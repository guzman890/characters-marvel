package com.openpay.marvel.api.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(
		basePackages = {
			"com.openpay.marvel.api.client",
			"com.openpay.marvel.api.rest"
		})
@EnableFeignClients(basePackages = "com.openpay.marvel.api.client.web")
public class MarvelApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarvelApiRestApplication.class, args);
	}

}
