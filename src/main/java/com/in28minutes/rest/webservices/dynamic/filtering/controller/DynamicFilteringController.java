/**
 * 
 */
package com.in28minutes.rest.webservices.dynamic.filtering.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

/**
 * @author 109726
 *
 */

@RestController
public class DynamicFilteringController {

	/**
	 * Filtering field1,field2	  
	 */
	 @GetMapping("/dynamic/filtering")
	 public MappingJacksonValue retrieveSomeBean(){
		 SomeBean someBean = new SomeBean("value1","value2","value3");
		 SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		 return filterBeanProperties(someBean,filter);
	 }

	 /**
	  * Filtering field2,field3	  
	  */			
	 @GetMapping("/dynamic/filtering-list")
	 public MappingJacksonValue retrieveListOfSomeBeans(){
		 List<SomeBean> list = Arrays.asList(new SomeBean("value1","value2","value3"),
				 new SomeBean("value21","value22","value23"));
		 SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
		 return filterBeanProperties(list,filter);
	 }

	 /**
	  * 
	  * @param obj
	  * @param filter
	  * @return mapping of data and filter criteria
	  */
	 private MappingJacksonValue filterBeanProperties(Object obj, SimpleBeanPropertyFilter filter){
		 FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		 MappingJacksonValue mapping = new MappingJacksonValue(obj);
		 mapping.setFilters(filters);
		 return mapping;
	 }
}
