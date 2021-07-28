package com.example.demo.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

	@GetMapping("v1/person")
	public Persion1 getPerson1() {

		return new Persion1("bod the builder");
	}


	@GetMapping("v2/person")
	public Person2 getPerson2() {

		return new Person2(new Name("bod", "builder"));
	}

	
	@GetMapping(value="param/person", params="version=1")
	public Persion1 getParamPerson1() {

		return new Persion1("bod the builder");
	}


	@GetMapping(value="param/person", params="version=2")
	public Person2 getParamPerson2() {

		return new Person2(new Name("bod", "builder"));
	}

	@GetMapping(value="header/person", headers="v=1")
	public Persion1 getHeaderPerson1() {

		return new Persion1("bod the builder");
	}


	@GetMapping(value="header/person", headers="v=2")
	public Person2 getHeaderPerson2() {

		return new Person2(new Name("bod", "builder"));
	}


}
