package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.User;
import com.repository.UserRepo;

@Service
public class LogoutServiceImpl implements LogoutService{
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepo userRepo;
	
	@Override
	public String doProcess(String uname) {
		User user = userRepo.findByUname(uname);
		if(user!=null) {
			userService.updateFlag(uname, 0);
			userRepo.save(user);
		}
	    return "login";
	}
}
