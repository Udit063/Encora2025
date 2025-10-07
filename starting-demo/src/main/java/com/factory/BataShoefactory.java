package com.factory;

import org.springframework.stereotype.Component;

@Component("bsf")
public class BataShoefactory extends ShoeFactory {
	@Override 
	public Shoe makeShoe() {
		return new LeatherShoe();
	}
}
