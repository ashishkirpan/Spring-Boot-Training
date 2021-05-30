package com.example.rest.restfulwebservices;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.rest.restfulwebservices.bean.User;

@Component
public class UserDaoService {

	private static ArrayList<User> users = new ArrayList<>();
	
	private static int userCount = 103;
	
	static {
		users.add(new User(101, "John", new Date()));
		users.add(new User(102, "Mike", new Date()));
		users.add(new User(103, "Adam", new Date()));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User findById(int id) {
		for(User user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		
		return null;
	}
	
	public User save(User user) {
		if(user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
}
