package com.configuration;

public class MyBeanComponent {
	String msg;
	public MyBeanComponent() {
		System.out.println("cons of my bean component called...");
	}
	
	public MyBeanComponent(String msg) {
		this.msg = msg;
	}
	
	public String getMsg() {
		return "Message is...:"+msg;
	}
	
	public void init() {
		System.out.println("init of mybean component called....");
	}
	
	public void destroy() {
		System.out.println("destroy of mybean component called...");
	}
}
