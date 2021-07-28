package com.example.demo.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String helloWorld()
	{
		return "hello-wrold";
	}
	
	
	@GetMapping("/helloWorl")
	public HelloBean helloWorldBean()
	{
		return new HelloBean("bean created");
	}

	@GetMapping("/helloWorl/{id}")
	public HelloBean helloWorldId(@PathVariable int id)
	{
		return new HelloBean("bean created + "+ id);
	}

}
