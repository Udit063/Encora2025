package com.service;

import java.util.List;

import com.model.Items;

public interface ItemsService {
	public void addItems(Items item);
	public List<Items> findByCategories(Items.Category category);
	public List<Items> findBySelectedIds(List<Integer> selectedItemIds);
}
