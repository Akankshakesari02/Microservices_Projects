package com.example.microservices.repository;

import org.springframework.stereotype.Repository;

import com.example.microservices.bean.ExchangeValue;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<ExchangeValue,Long>{
	
	public ExchangeValue findByFromAndTo(String from ,String to);

}
