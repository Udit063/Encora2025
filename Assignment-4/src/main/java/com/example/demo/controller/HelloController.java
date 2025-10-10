package com.example.demo.controller;

import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

@RestController
public class HelloController {
	@GetMapping("/hello")
	public String hello(Principal principal) {
		if (principal instanceof OAuth2User oAuth2User) {
			String name = oAuth2User.getAttribute("name");
			return "Hello, " + name + "! You logged in via OAuth2  ";
		}
		return "Hello, " + principal.getName();
	}
}
