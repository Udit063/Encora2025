package com.encora.service.compkey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encora.model.compkey.CompKey;
import com.encora.model.compkey.ItemTransaction;
import com.encora.repository.compkey.CompKeyRepo;

@Service
public class CompKeyService {
	@Autowired
	private CompKeyRepo compKeyRepo;
	
	public void insert() {
		CompKey compKey = new CompKey();
		compKey.setBillno(9001);
		compKey.setItemno(104);
		
		ItemTransaction it = new ItemTransaction();
		it.setMykey(compKey);
		it.setQty(200);
		
		compKeyRepo.save(it);
	}

}
