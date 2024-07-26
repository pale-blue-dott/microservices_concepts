package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EmployeeController {
	// a class/interface used for fetching services registerd on discovery server
	// it does not have load balancing capability
	private DiscoveryClient discoveryClient;
	
	//DicoveryClient + load-balancing
	private LoadBalancerClient loadBalancerClient;
	@Autowired
	private RestTemplate restTemplate;
	
	
	@GetMapping("/api/employee/{empId}")
	public String getEmployeeDetail(@PathVariable("empId") int id) {
		/*
		List<ServiceInstance> instances=discoveryClient.getInstances("address-service");
		// this methodology is not load-balancing the requests
		// always give the same instance as we can see below line code
		ServiceInstance serviceInstance=instances.get(0);
		String uri=serviceInstance.getUri().toString();
		
		
		String address=restTemplate.getForObject(uri, String.class);
		return "Ankit kr, Backend Dev" + address;
		*/
		
		/*
		ServiceInstance serviceInstance=loadBalancerClient.choose("address-service");
		serviceInstance.getMetadata().get("configPath");
		String url=serviceInstance.getUri().toString();
		return restTemplate.getForObject(url, String.class, id);
		*/
		
		// since, restTemplate does not have load balancing capablitities, we annotate "@LoadBalanced" at bean
		// in config class where RestTemplate bean is defined
		return restTemplate.getForObject("http://ADDRESS-SERVICE/address-app/address/{id}", String.class, id);
	}

}
