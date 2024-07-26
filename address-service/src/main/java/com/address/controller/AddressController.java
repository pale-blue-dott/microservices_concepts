package com.address.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AddressController {


	@GetMapping("api/address/{addressId}")
	public String getAddress(@PathVariable("addressId") int id) {
		return "Ekchari Bazar, Bhagalput-813204";
	}
}
