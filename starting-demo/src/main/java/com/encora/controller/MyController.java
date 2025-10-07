package com.encora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.encora.service.MyService;

@Component
public class MyController {
	public MyController() {
		System.out.println("Controller cons called...");
	}
	
//	Autowired is used to access the classes of other packages
	@Autowired
	private MyService myservice;
	
	public void Test() {
		System.out.println("My service from controller : " + myservice);
	}
}
