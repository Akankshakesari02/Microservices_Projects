package com.example.demo.filter;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;



@RestController
public class FilterController {
	
	@GetMapping("/filtering")
	public StaticFilterBean getStaticFilterBean()
	{
		return new StaticFilterBean("vlue1", "value2", "value3");
	}
	
	
	@GetMapping("/filtering-list")
	public List<StaticFilterBean> getStaticFilterListBean()
	{
		return Arrays.asList(new StaticFilterBean("value1", "value2", "value3"),
				new StaticFilterBean("value11", "value21", "value31")) ;
	}
	
	//field1 field2
	@GetMapping("/Dynamicfiltering")
	public MappingJacksonValue getDynamicFilterBean()
	{
		DynamicFilterBean dynamicFilterBean = new DynamicFilterBean("value1", "value2", "value3");
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(dynamicFilterBean);
		
		mapping.setFilters(filters);
		return mapping;
	}
	
	@GetMapping("/DynamicFilter-list")
	public MappingJacksonValue getDynamicFilterList()
	{
		List<DynamicFilterBean> list = Arrays.asList( new DynamicFilterBean("value1", "value2", "value3"),new DynamicFilterBean("value12", "value22", "value32"));
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicBeanFilter", filter);
		mapping.setFilters(filters);
		return mapping;
	}
	

}
