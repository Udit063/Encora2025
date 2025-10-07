package com.factory;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class ShoeShop implements Seller {
	@Autowired
	private ShoeFactory factory;
		
	public ShoeFactory getFactory() {
		return factory;
	}
	
	public void setFactory(ShoeFactory factory) {
		this.factory = factory;
	}
}
