package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.User;
import com.repository.UserRepo;

import jakarta.servlet.http.HttpSession;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired 
	UserRepo userRepo;
	
	@Autowired
	UserService userService;
	
	public String doProcess(String uname, String upass, HttpSession session) {
		User user = userRepo.findByUname(uname);
		System.out.println("user log in : " + user);
		if(user!=null) {
			if(user.getUpass().equals(upass)) {
				userService.updateFlag(uname, 1);
				session.setAttribute("user", user);
				return "welcome";
			} else {
				return "login";
			}
		}
		return "register";
	}
}
