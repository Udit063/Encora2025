package com.example.demo.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.web.bind.annotation.*;
import java.security.Key;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam(defaultValue = "ROLE_USER") String role) {
		return Jwts.builder().setSubject(username).claim("roles", List.of(role)) // embedding roles into token
				.setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1hour expiry
				.signWith(key).compact();
	}

	public Key getKey() {
		return key;
	}
}
