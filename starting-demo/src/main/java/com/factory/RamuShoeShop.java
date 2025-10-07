package com.factory;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("rsshop")
public class RamuShoeShop extends ShoeShop {
	public RamuShoeShop() {
		System.out.println("Contructor called...");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("After the constructor...");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Destroyed method called...");
	}
	
	@Override
	public Shoe sellShoe(Customer customer) {
		return getFactory().makeShoe();
	}
}
