package com.example.rest.restfulwebservices.controller;

import java.util.List;

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

@RestController
public class UserController {

	@Autowired
	private UserDaoService userDaoService;
	
	//GET /users
	//retriveAllUsers
	@GetMapping(path = "/users")
	public List<User> retriveAllUsers() {
		return userDaoService.findAll();
	}
	
	//GET /users/{id}
	//retriveUserDetails
	@GetMapping(path = "/users/{id}")
	public User retriveUserDetails(@PathVariable int id) {
		return userDaoService.findById(id);
	}
	
	//POST /users
	//saveUser
	@PostMapping(path = "/users")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User createdUser = userDaoService.save(user);
		if(createdUser == null) {
			new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	//DELETE /users/{id}
	//deleteUser
	@DeleteMapping(path = "/users/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable int id) {
		userDaoService.remove(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
}
