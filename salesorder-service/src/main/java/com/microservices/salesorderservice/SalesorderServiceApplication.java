package com.microservices.salesorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("com.microservices.salesorderservice")
@EnableDiscoveryClient
@EnableCircuitBreaker
@SpringBootApplication
public class SalesorderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesorderServiceApplication.class, args);
	}

}
