package com.service;

import java.util.ArrayList;
import java.util.List;
import com.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Items;
import com.model.Items.Category;
import com.repository.ItemsRepo;

@Service
public class ItemsServiceImpl implements ItemsService {

    private final UserRepo userRepo;
	@Autowired
	public ItemsRepo itemsRepo;

    ItemsServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
	
	@Override
	public void addItems(Items item) {
		Items newItem = itemsRepo.findByItemName(item.getItemName());
		if(newItem == null) {
			Items it = new Items();
			it.setItemName(item.getItemName());
			it.setPrice(item.getPrice());
			it.setQuantity(item.getQuantity());
			it.setCategory(item.getCategory());
			System.out.println("it : " + it);
			itemsRepo.save(it);
		}
	}
	
	@Override
	public List<Items> findByCategories(Items.Category category){
		List<Items> item = new ArrayList<>();
		item = itemsRepo.findByCategory(category);
		System.out.println("item in service: " + item);
		return item;
	}
	
	@Override
	public List<Items> findBySelectedIds(List<Integer> selectedItemIds){
		List<Items> selectedItems = new ArrayList<>();
		for(int id:selectedItemIds) {
			selectedItems.add(itemsRepo.findByItemId(id));
		}
		return selectedItems;
	}
}
