package com.employee.openFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@EnableFeignClients must be annotated where @SpringBootApplication is annoatated by SpringBoot
// name should have the value which is registered over DiscoveryServer(service where we have to make rest calls)
// path=context-path defined inside properties file of service where we make rest call
@FeignClient(name="address-service", path="/address-app/api")
public interface AddressFeignClient {
	
	@GetMapping("/address/{empId}")
	public String getAddressByEmpId(@PathVariable("empId") int id);
}
