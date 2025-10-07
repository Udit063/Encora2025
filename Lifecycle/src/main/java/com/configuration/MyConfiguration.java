package com.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.service.MyService;
import com.service.MyServiceImpl1;
import com.service.MyServiceImpl2;

@Configuration
public class MyConfiguration {
	public MyBeanComponent getBean() {
		return new MyBeanComponent("Thisis custom message!!");
	}
	
	@Bean(name="ms1")
	@Profile("developer")
	public MyService getMs1() {
		return new MyServiceImpl1();
	}
	
	@Bean(name="ms2")
	@Profile("admin")
	public MyService getMs2() {
		return new MyServiceImpl2();
	}

}
