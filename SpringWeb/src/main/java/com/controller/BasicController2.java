package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/bs2")
public class BasicController2 {
	@RequestMapping(method=RequestMethod.GET, value="hello")
	public void sayHello(HttpServletRequest req) {
		System.out.println("say hello method..." + req);
		HttpSession session = req.getSession();
		System.out.println("session " + session.getId());
		session.setAttribute("mykey", "this is my key value...");
		String str = session.getAttribute("mykey").toString();
		System.out.println("value : " +  str);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/hello2")
	public void sayHello2(HttpSession session) {
		System.out.println("session " + session.getId());
		String str =session.getAttribute("mykey").toString();
		System.out.println("value : "+str);
	}
}