package com.tradingsystem.registryserver.traderegistryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TradeRegistryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradeRegistryServerApplication.class, args);
	}

}
