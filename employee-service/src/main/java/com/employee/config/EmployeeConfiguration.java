package com.employee.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class EmployeeConfiguration {

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		System.out.println("Instantiating Reest Template");
		return new RestTemplate();
	}
}
