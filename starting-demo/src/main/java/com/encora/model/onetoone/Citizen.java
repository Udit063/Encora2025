//package com.encora.model.onetoone;
//
//import java.io.Serializable;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToOne;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name="indiancitizen")
//public class Citizen implements Serializable, Comparable<Citizen>{
//	
//	@Id
//	@Column(name="citizenid")
//	@GeneratedValue(strategy = GenerationType.AUTO)  // it is used to autogenerate the value instead of entering different by the user
//	private int cid;
//	
//	private String cname;
//	
//	@OneToOne(cascade = CascadeType.ALL)  // if I change in one, then in other class will also get changed, no need to update it separately
//	@JoinColumn(name="address_id", referencedColumnName = "aid")
//	private Address address;
//
//	public int getCid() {
//		return cid;
//	}
//
//	public void setCid(int cid) {
//		this.cid = cid;
//	}
//
//	public String getCname() {
//		return cname;
//	}
//
//	public void setCname(String cname) {
//		this.cname = cname;
//	}
//
//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}
//
//	@Override
//	public String toString() {
//		return "Citizen [cid=" + cid + ", cname=" + cname + ", address=" + address + "]";
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + cid;
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Citizen other = (Citizen) obj;
//		if (cid != other.cid)
//			return false;
//		return true;
//	}
//	
//	@Override
//	public int compareTo(Citizen o) {
//		return Integer.compare(this.cid, o.cid);
//	}
//	
//}

package com.encora.model.onetoone;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="indiancitizen")
public class Citizen implements Serializable, Comparable<Citizen>{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	
	private String cname;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address_id", referencedColumnName = "aid")
	private Address address;

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	

	@Override
	public String toString() {
		return "Citizen [cid=" + cid + ", cname=" + cname + ", address=" + address + "]";
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
		Citizen other = (Citizen) obj;
		return cid == other.cid;
	}
	
	@Override
	public int compareTo(Citizen c) {
		return Integer.compare(this.cid, c.cid);
	}
	
	
}
