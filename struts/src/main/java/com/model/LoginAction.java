package com.model;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginAction extends Action {
	public LoginAction() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String uname = request.getParameter("uname");
		if(uname.equals("udit")) {
			return "login.success";
		} 
		return "login.failure";
		
	}

}
