package com.example.microservices.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.bean.ExchangeValue;
import com.example.microservices.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {
	@Autowired
	Environment environment;
	
	@Autowired
	CurrencyExchangeRepository repo;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue getCurrencyConversion(@PathVariable String from , @PathVariable String to)
	{
		 
		 ExchangeValue exchange=repo.findByFromAndTo(from, to);
		 exchange.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		 return exchange;
		 
	}

}
