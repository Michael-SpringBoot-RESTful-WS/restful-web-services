/**
 * 
 */
package com.in28minutes.rest.webservices.helloworld.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.helloworld.model.HelloWorldBean;

/**
 * @author 109726
 *
 */

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
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
	
	/*
	 * The 2nd argument in messageSource.getMessage() stands for arguments to provide custom message
	 * It means that we can pass some values as an arguments to message source dynamically and 
	 * those will be replaced with place holders in the message content
	 * This helps us to construct some messages dynamically
	 */
	@GetMapping("/hello-world-internationalized")
	public String helloWorldInternationalized(@RequestHeader(name="Accept-Language",required=false) Locale locale){
		return messageSource.getMessage("good.morning.message",null,locale);
	}
	
	/*
	 * The 2nd argument in messageSource.getMessage() stands for arguments to provide custom message
	 * It means that we can pass some values as an arguments to message source dynamically and 
	 * those will be replaced with place holders in the message content
	 * This helps us to construct some messages dynamically
	 */
	@GetMapping("/hello-world-internationalized-from-context")
	public String helloWorldInternationalizedFromContext(){
		return messageSource.getMessage("good.morning.message",null,LocaleContextHolder.getLocale());
	}
	
}
