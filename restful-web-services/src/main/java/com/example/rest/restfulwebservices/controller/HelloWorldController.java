package com.example.rest.restfulwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.restfulwebservices.bean.HelloWorldBean;

//Controller
@RestController
public class HelloWorldController {

	//GET
	//URI - /hello-world
	//Return String - Hello World
	//@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	//GET
	//URI - /hello-world-bean
	//Return Bean - HelloWorldBean 
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
		
}
