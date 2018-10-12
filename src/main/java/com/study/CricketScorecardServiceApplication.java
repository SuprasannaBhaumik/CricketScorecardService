package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CricketScorecardServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CricketScorecardServiceApplication.class, args);
	}
}
