package com.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	int custId;

	@ElementCollection
	List<Integer> itemIds = new ArrayList<>();

//	@OneToMany(mappedBy = "bill" , cascade = CascadeType.MERGE)
//	List<Items> items;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Integer> getItemIds() {
		return itemIds;
	}

	public void setItemIds(List<Integer> itemIds) {
		this.itemIds = itemIds;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", custId=" + custId + ", itemIds=" + itemIds + "]";
	}

//	public List<Items> getItems() {
//		return items;
//	}
//
//	public void setItems(List<Items> items) {
//		this.items = items;
//	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

}
