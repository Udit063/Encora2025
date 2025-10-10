package com.example.demo.config;

import com.example.demo.controller.AuthController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.security.web.SecurityFilterChain;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

@Configuration
public class SecurityConfig {
	private final AuthController authController;

	public SecurityConfig(AuthController authController) {
		this.authController = authController;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth.requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/api/auth/**")
						.permitAll().requestMatchers("/api/admin/**").hasRole("ADMIN").anyRequest().authenticated())
				.oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(this::convertJwt)));
		return http.build();
	}

	@Bean
	public JwtDecoder jwtDecoder() {
		return NimbusJwtDecoder.withSecretKey((SecretKey) authController.getKey()).build();
	}

	private AbstractAuthenticationToken convertJwt(Jwt jwt) {
		Collection<GrantedAuthority> authorities = ((List<String>) jwt.getClaims().get("roles")).stream()
				.map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		return new org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken(jwt,
				authorities);
	}
}