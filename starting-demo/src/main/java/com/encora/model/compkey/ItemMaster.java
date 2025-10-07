package com.encora.model.compkey;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class ItemMaster {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int iid;
	
	private int itemNo;
	private String itemDescription;
	private int itemPrice;
	
	@OneToMany(mappedBy = "itemMaster", cascade = CascadeType.ALL)
	private List<ItemTransaction> iTransaction = new ArrayList<>();

	public int getIid() {
		return iid;
	}
	
	public List<ItemTransaction> getiTransaction() {
		return iTransaction;
	}

	public void setiTransaction(List<ItemTransaction> iTransaction) {
		this.iTransaction = iTransaction;
	}

	public void setIid(int iid) {
		this.iid = iid;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return "ItemMaster [iid=" + iid + ", itemNo=" + itemNo + ", itemDescription=" + itemDescription + ", itemPrice="
				+ itemPrice + ", iTransaction=" + iTransaction + "]";
	}
	
}
