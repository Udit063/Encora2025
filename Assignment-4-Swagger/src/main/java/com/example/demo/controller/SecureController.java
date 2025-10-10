package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SecureController {
	@GetMapping("/secure")
	public String userEndpoint() {
		return "Hello USER - you are authenticated!";
	}

	@GetMapping("/admin/secure")
	public String adminEndpoint() {
		return "Hello ADMIN - you have admin privileges!";
	}
}
