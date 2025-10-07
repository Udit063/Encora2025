package com.encora.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MyRepository {
	public MyRepository() {
		System.out.println("Repository cons called...");
	}
}
