package com.encora.model.compkey;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class ItemTransaction {
	// composite key
	@EmbeddedId
	private CompKey mykey;
	private int qty;
	
	@ManyToOne
	private ItemMaster itemMaster;
	
	@OneToMany(mappedBy = "itemTransaction", cascade = CascadeType.ALL)
	private List<BillMaster> billMaster = new ArrayList<>();
	
	public List<BillMaster> getBillMaster() {
		return billMaster;
	}
	public void setBillMaster(List<BillMaster> billMaster) {
		this.billMaster = billMaster;
	}
	public ItemMaster getItemMaster() {
		return itemMaster;
	}
	public void setItemMaster(ItemMaster itemMaster) {
		this.itemMaster = itemMaster;
	}
	public CompKey getMykey() {
		return mykey;
	}
	public void setMykey(CompKey mykey) {
		this.mykey = mykey;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
}
