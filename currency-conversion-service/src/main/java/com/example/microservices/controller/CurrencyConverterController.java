package com.example.microservices.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.microservices.bean.CurrencyConversionBean;

@RestController
public class CurrencyConverterController {
	@Autowired
	public RestTemplate restTemplate;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from,
			@PathVariable String to,@PathVariable BigDecimal quantity)
	{
		Map<String,String> uriVarialbe = new HashMap<String, String>();
		uriVarialbe.put("from", from);
		uriVarialbe.put("to", to);
		
		ResponseEntity<CurrencyConversionBean> forEntity = restTemplate.getForEntity("http://currency-exchange-service/currency-exchange/from/{from}/to/{to}", 
				CurrencyConversionBean.class,uriVarialbe
				);
		CurrencyConversionBean response = forEntity.getBody();
		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity, quantity.multiply(response.getConversionMultiple()), response.getPort());
	}
	
	

}
