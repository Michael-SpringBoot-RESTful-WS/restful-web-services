/**
 * 
 */
package com.in28minutes.rest.webservices.user.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.webservices.user.dao.UserDaoService;
import com.in28minutes.rest.webservices.user.exception.UserNotFoundExceptin;
import com.in28minutes.rest.webservices.user.model.User;

/**
 * @author 109726
 *
 */
@RestController
public class UserController {

	@Autowired
	private UserDaoService userDaoService;


	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return userDaoService.finadAll();
	}

	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id){
		User foundOne = userDaoService.findOne(id);
		if(foundOne==null)
			throw new UserNotFoundExceptin("id-"+id);
		return foundOne;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user){
		//public User createUser(@RequestBody User user){
		User userSaved = userDaoService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userSaved.getId()).toUri();
		//return userSaved;
		return ResponseEntity.created(location).build();
	}

}
