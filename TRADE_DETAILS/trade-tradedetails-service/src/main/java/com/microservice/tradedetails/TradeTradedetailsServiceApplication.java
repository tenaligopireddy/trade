package com.microservice.tradedetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TradeTradedetailsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradeTradedetailsServiceApplication.class, args);
	}

}
