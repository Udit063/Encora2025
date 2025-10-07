package com.shopping.model.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.service.UserServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("register")
public class RegisterAction extends Action {
	@Autowired
	UserServiceImpl userService;
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String uname = req.getParameter("uname");
		String upass = req.getParameter("upass"); 
		
		
			userService.insert(uname, upass);
			return "register.success";
		
		
	}
}
