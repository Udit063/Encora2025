package com.encora.model.compkey;

import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BillMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bill_no;
	private Date bill_date;
	private int discount;
	
	@ManyToOne
//	@JoinColumn(name = "customer_id")
	private CustomerMaster customer_master;
	
	@ManyToOne
//	@JoinColumn(name = "transaction_id")
	private ItemTransaction itemTransaction;
	
	public ItemTransaction getItemTransaction() {
		return itemTransaction;
	}

	public void setItemTransaction(ItemTransaction itemTransaction) {
		this.itemTransaction = itemTransaction;
	}

	public int getBill_no() {
		return bill_no;
	}

	public void setBill_no(int bill_no) {
		this.bill_no = bill_no;
	}

	public Date getBill_date() {
		return bill_date;
	}

	public void setBill_date(Date bill_date) {
		this.bill_date = bill_date;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public CustomerMaster getCustomer_master() {
		return customer_master;
	}

	public void setCustomer_master(CustomerMaster customer_master) {
		this.customer_master = customer_master;
	}

	@Override
	public String toString() {
		return "BillMaster [bill_no=" + bill_no + ", bill_date=" + bill_date + ", discount=" + discount + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bill_no);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BillMaster other = (BillMaster) obj;
		return bill_no == other.bill_no;
	}
	
}
