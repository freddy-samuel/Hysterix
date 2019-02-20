package com.boa.kyc.hystrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boa.kyc.hystrix.CustomerRequestHandler;

@RestController
public class HystrixController {

	@Autowired
	private CustomerRequestHandler handler;

	@GetMapping("/getcustomers")
	public String getResponse() {
		return handler.handleRequests();
	}
}
