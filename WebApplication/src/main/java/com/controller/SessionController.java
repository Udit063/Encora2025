package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.LogoutServiceImpl;
import com.service.UserService;
import com.service.UserServiceImpl;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@Component
@WebListener
public class SessionController implements HttpSessionListener {
	
	@Autowired
	UserService us;
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("Session created!!");
		HttpSession session = se.getSession();
		session.setMaxInactiveInterval(10000);
		HttpSessionListener.super.sessionCreated(se);
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("Session Destroyed!!");
		HttpSession session = se.getSession();
		String name = (String)session.getAttribute("user");
		us.updateFlag(name, 0);
		HttpSessionListener.super.sessionDestroyed(se);
	}
}
