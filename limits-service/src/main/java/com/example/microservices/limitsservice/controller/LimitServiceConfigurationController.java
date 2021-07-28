package com.example.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.limitsservice.Configuration;
import com.example.microservices.limitsservice.bean.LimitConfigure;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitServiceConfigurationController {

	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")

	public LimitConfigure getLimitConfig() {
		return new LimitConfigure(configuration.getMaximum(), configuration.getMinimum());
	}

	@GetMapping("/fault-tolerance-example")
	@HystrixCommand(fallbackMethod="fallbackConfig")
	public LimitConfigure retrieveCOnfiguration() {
		throw new RuntimeException("not available");

	}
	
	public LimitConfigure fallbackConfig() {
		return new LimitConfigure(9, 1000);
	}
	
	}


