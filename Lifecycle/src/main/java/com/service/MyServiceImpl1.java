package com.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service("ms1")
@Profile("developer")
public class MyServiceImpl1 implements MyService {
	@Override
	public void myServiceMet() {
		System.out.println("This is my first implementation....");		
	}
}
