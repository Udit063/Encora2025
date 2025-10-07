package com.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service("ms2")
@Profile("admin")
public class MyServiceImpl2 implements MyService {
	@Override
	public void myServiceMet() {
		System.out.println("This is my second implementation....");		
	}
}
