package com.encora.model.compkey;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class CustomerMaster {
	@Id
	private int cid;
	private String cname;
	private String caddress;
	
	@OneToMany(mappedBy = "customer_master", cascade = CascadeType.ALL)
	private List<BillMaster> bill_master = new ArrayList<>();

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCaddress() {
		return caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	public List<BillMaster> getBill_master() {
		return bill_master;
	}

	public void setBill_master(List<BillMaster> bill_master) {
		this.bill_master = bill_master;
	}

	@Override
	public String toString() {
		return "CustomerMaster [cid=" + cid + ", cname=" + cname + ", caddress=" + caddress + ", bill_master="
				+ bill_master + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerMaster other = (CustomerMaster) obj;
		return cid == other.cid;
	}
	
	
	
}
