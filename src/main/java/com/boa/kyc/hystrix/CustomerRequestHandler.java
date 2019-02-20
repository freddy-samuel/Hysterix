package com.boa.kyc.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CustomerRequestHandler {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod="handleFallBacks")
	public String handleRequests() {
		String response = restTemplate.exchange("http://localhost:7070/getallcustomers", HttpMethod.GET, null,
				new ParameterizedTypeReference<String>() {
				}).getBody();
		return response;
	}

	public String handleFallBacks() {
		String response = restTemplate.exchange("http://localhost:7085/getallcustomers", HttpMethod.GET, null,
				new ParameterizedTypeReference<String>() {
				}).getBody();
		return response;
	}
	
	public RestTemplate getInstance() {
		return new RestTemplate();
	}
}
