/**
 * 
 */
package com.in28minutes.rest.webservices.user.controller;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.webservices.user.dao.UserDaoService;
import com.in28minutes.rest.webservices.user.exception.UserNotFoundException;
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
	public Resource<User> retrieveUser(@PathVariable int id){
		User foundOne = userDaoService.findOne(id);
		if(foundOne==null)
			throw new UserNotFoundException("id-"+id);
		// "all-users", SERVER_PATH + "/users"
		//retrieveAllUsers
		Resource<User> resource = new Resource<User>(foundOne);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id){
		User deletedOne = userDaoService.deleteById(id);
		if(deletedOne==null)
			throw new UserNotFoundException("id-"+id);
	}


	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
		//public User createUser(@RequestBody User user){
		User userSaved = userDaoService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userSaved.getId()).toUri();
		//return userSaved;
		return ResponseEntity.created(location).build();
	}

}
