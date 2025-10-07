package com.shopping.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.model.Items;
import com.shopping.model.User;
import com.shopping.respository.BillRepo;
import com.shopping.respository.ItemRepo;

@Service
public class BillServiceImpl implements BillService {
	@Autowired
	private ItemRepo itemrepo;
	
	@Autowired
	private BillRepo billRepo;
	
	@Override
	public int generateBill(List<String> itemNames, User user) {
		int totalPrice = 0;
		List<Items> selectedItems = new ArrayList<>();
		for(String i : itemNames) {
			Items currentItem = itemrepo.findByName(i);
			if(currentItem != null) {
				selectedItems.add(currentItem);
				totalPrice += currentItem.getPrice();
			}
		}
		
		System.out.println(selectedItems);
		System.out.println(totalPrice);
		return totalPrice;
	}
}
