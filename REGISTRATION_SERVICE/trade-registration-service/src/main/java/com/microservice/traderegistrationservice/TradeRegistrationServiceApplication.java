package com.microservice.traderegistrationservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableFeignClients("com.microservice.traderegistrationservice")
@EnableDiscoveryClient
public class TradeRegistrationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradeRegistrationServiceApplication.class, args);
	}

}
