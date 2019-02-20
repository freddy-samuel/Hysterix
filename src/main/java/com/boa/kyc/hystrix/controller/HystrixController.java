package com.boa.kyc.hystrix.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixController {

	@GetMapping("/getcustomers")
	public String getResponse() {
		return "";
	}
}
