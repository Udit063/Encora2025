package com.model;

import java.util.List;

public class ShopItem {
	private List<Integer> selectedItemIds;
	
	public List<Integer> getSelectedItemIds() {
		return selectedItemIds;
	}

	public void setSelectedItemIds(List<Integer> selectedItemIds) {
		this.selectedItemIds = selectedItemIds;
	}


	@Override
	public String toString() {
		return "ShopItem [selectedItemIds=" + selectedItemIds + "]";
	}
}
