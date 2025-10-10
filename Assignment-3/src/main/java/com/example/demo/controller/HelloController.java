package com.example.demo.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.util.JwtUtil;

@RestController
public class HelloController {

	@PostMapping("/api/AdminToken")
	public String generateAdminToken(@RequestBody String username) {
		String token = JwtUtil.generateToken(username, List.of("ROLE_ADMIN"));
		System.out.println("token : " + token);
		return token;
	}

	@PostMapping("/api/UserToken")
	public String generateUserToken(@RequestBody String username) {
		String token = JwtUtil.generateToken(username, List.of("ROLE_USER"));
		System.out.println("Token: " + token);
		return token;
	}

	@GetMapping("/api/hello")
	public String hello(Authentication auth) {
		return "Hello, " + auth.getName() + "! You are authenticated.";
	}

	@GetMapping("/api/admin")
	public String admin(Authentication auth) {
		return "Welcome Admin, " + auth.getName() + "! You have special access.";
	}
}