package com.example.rest.restfulwebservices.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.restfulwebservices.bean.User;
import com.example.rest.restfulwebservices.dao.UserDaoService;
import com.example.rest.restfulwebservices.dao.UserRepository;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
public class UserJPAController {

	@Autowired
	private UserDaoService userDaoService;
	
	@Autowired
	private UserRepository userRepository;
	
	//GET /users
	//retriveAllUsers
	@Tag(name = "retriveAllUsers", description = "Retrieves all the users from database")
	@ApiResponse(responseCode = "200", description = "Returs the details of all available users")
	@GetMapping(path = "/jpa/users")
	public List<User> retriveAllUsers() {
		return userRepository.findAll();
	}
	
	//GET /users/{id}
	//retriveUserDetails
	@Tag(name = "retriveUserDetails", description = "Retrieves the user details")
	@ApiResponse(responseCode = "200", description = "Returs the details of specified user")
	@Parameter(name = "id", description = "Unique id of the user")
	@GetMapping(path = "/jpa/users/{id}")
	public User retriveUserDetails(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		return user.get();
	}
	
	//POST /users
	//saveUser
	@PostMapping(path = "/jpa/users")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User createdUser = userRepository.save(user);
		if(createdUser == null) {
			new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	//DELETE /users/{id}
	//deleteUser
	@DeleteMapping(path = "/jpa/users/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
}
