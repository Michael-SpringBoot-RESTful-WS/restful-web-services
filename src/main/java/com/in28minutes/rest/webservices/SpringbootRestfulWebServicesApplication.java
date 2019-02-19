package com.in28minutes.rest.webservices;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class SpringbootRestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfulWebServicesApplication.class, args);
	}

	/**
	 * the following configuration is only for @GetMapping("/hello-world-internationalized")
	 * for the way of referring the Locale presented in Request Header
	 */
/*	@Bean
	public LocaleResolver localeResolver(){
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}*/
	
	/**
	 * the following configuration is for @GetMapping("/hello-world-internationalized-from-context")
	 * for the way of referring the Locale presented in Request Header
	 */
	@Bean
	public LocaleResolver localeResolver(){
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	// The following configuration can be done at application.properties file also
	/*@Bean
	public ResourceBundleMessageSource messageSource(){
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");		
		return messageSource;
	}*/
}

