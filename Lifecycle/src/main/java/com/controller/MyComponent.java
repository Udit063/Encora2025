package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.configuration.MyBeanComponent;
import com.service.MyService;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Scope("prototype")
public class MyComponent {
	
	@Autowired
	private MyBeanComponent mybc;
	
	@Autowired
	@Qualifier("mys2")
	private MyService mys;
	
	public MyComponent() {
		System.out.println("cons called...");
	}
	
	public void met() {
		System.out.println("met called....");
		System.out.println(mybc.getMsg());
		mys.myServiceMet();
	}
	
	@PostConstruct
	public void init() {
		System.out.println("called after the constructor....");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("pre destroy called....");
	}
}
