package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Items {
	public enum Category{
		Electronics,
		Food,
		Beverages
	};
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int itemId;
	
//	@ManyToOne
//	private Bill bill;
	
	String itemName;
	int quantity;
	int price;
	
	@Enumerated(EnumType.STRING)
	private Category category;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	@Override
	public String toString() {
		return "Items [itemId=" + itemId + ", itemName=" + itemName + ", quantity=" + quantity + ", price=" + price
				+ ", category=" + category + "]";
	}

//	public Bill getBill() {
//		return bill;
//	}
//
//	public void setBill(Bill bill) {
//		this.bill = bill;
//	}
//	
	
	
}
