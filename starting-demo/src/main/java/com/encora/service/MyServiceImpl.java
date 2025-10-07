package com.encora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.encora.repository.MyRepository;

// lazy will be used so that it doesn't get automatically called, only called when we want to
@Service
@Lazy
public class MyServiceImpl implements MyService {
	@Autowired
	private MyRepository myrepo;
	public MyServiceImpl() {
		System.out.println("service cons called...");
	}
}
