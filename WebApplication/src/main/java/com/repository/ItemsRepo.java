package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Items;
import com.model.Items.Category;

import java.util.List;


@Repository
public interface ItemsRepo extends JpaRepository<Items, Integer> {
	public List<Items> findByCategory(Category category);
	public Items findByItemName(String itemName);
	public Items findByItemId(int itemId);
}
