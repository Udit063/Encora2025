package com.shopping.model.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.service.UserServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component("login")
public class LoginAction extends Action{
	@Autowired
	private UserServiceImpl userService;
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String uname = req.getParameter("uname");
		String upass = req.getParameter("upass");
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("uname");
		
		if(userService.checkUser(uname, upass)) {
			if(userService.checkFlag(uname) || obj!=null) {
				return "login.already";
			}
			userService.updateFlag(uname, 1);
			session.setAttribute("uname", uname);
			return "login.success";
		}
		
		return "login.failure";
	}
}
