/**
 * 
 */
package com.in28minutes.rest.webservices.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.helloworld.model.HelloWorldBean;

/**
 * @author 109726
 *
 */

@RestController
public class HelloWorldController {
	
	@GetMapping("/hello-world")
	public String helloWorld(){
		return "Hello World";
	}

	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean(){
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping("/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
		return new HelloWorldBean(String.format("Hello World , %s", name));
	}
	
}
