package com.encora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.encora.repository.UsersRepository;
import com.encora.service.UserService;

@Component
public class UserController {
	@Autowired
	private UserService userservice;
	
	public String login(String uname, String password) throws Exception {
		boolean validUser = userservice.checkUser(uname, password);
		if(validUser) {
			if(userservice.checkFlag(uname)) {
				return "Already logged in";
			}
			userservice.updateFlag(uname, 1);
			return "login.success";
		} else {
			userservice.insert(uname, password);
			return "login.failed and new user inserted";
		}
	}
	
	public void logout(String uname) {
		userservice.updateFlag(uname, 0);
		System.out.println("user logout!");
	}
}
