package com.shopping.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.model.Items;
import com.shopping.model.User;

public interface BillService{
	public int generateBill(List<String> items, User user);
}
