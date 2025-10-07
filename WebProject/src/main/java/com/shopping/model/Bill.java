package com.shopping.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Bill implements Serializable, Comparable<Bill> {
	@Id
	private int billNo;
	private Date billDate;
	
	@ManyToOne
	private User user;

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Bill [billNo=" + billNo + ", billDate=" + billDate + ", user=" + user + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(billNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bill other = (Bill) obj;
		return billNo == other.billNo;
	}
	@Override
	public int compareTo(Bill o) {
		return Integer.compare(this.billNo, o.billNo);
	}
}
