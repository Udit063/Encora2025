package com.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class MyRestController1 {
	@GetMapping
	public void sayHello() {
		System.out.println("Welcome to spring MVC !!");
	}
	
	@GetMapping("/hello2")
	public String sayHello2() {
		System.out.println("Say hello 2 method is called....");
		return "wel";
	}
	
	@GetMapping("/hello3")
	public ResponseEntity<String> sayHello3() {
		System.out.println("response entity method called....");
		return ResponseEntity.ok("welcome");
	}
	
	@GetMapping("/hello4")
	public ResponseEntity<User> sayHello4(){
		User user = new User();
		user.setUpass("1234");
		user.setUname("ramu");
        return ResponseEntity.ok(user);
	}
	
	@PostMapping("/hello5")
	public ResponseEntity<User> sayHello5(@RequestBody User user) {
		//User user=new User();
		user.setUpass("1234"+user.getUpass());
		user.setUname("ramu"+user.getUname());
        return ResponseEntity.ok(user);
    }
}
