//package com.encora.model.onetoone;
//
//import java.io.Serializable;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToOne;
//
//@Entity
//public class Address implements Serializable,Comparable<Address>{
//
//	@Id
//	@GeneratedValue(strategy =GenerationType.AUTO)
//	private int aid;
//	private String city;
//	
//	@OneToOne(mappedBy = "address")
//	private Citizen citizen;
//
//	public int getAid() {
//		return aid;
//	}
//
//	public void setAid(int aid) {
//		this.aid = aid;
//	}
//
//	public String getCity() {
//		return city;
//	}
//
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//	public Citizen getCitizen() {
//		return citizen;
//	}
//
//	public void setCitizen(Citizen citizen) {
//		this.citizen = citizen;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + aid;
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
//		Address other = (Address) obj;
//		if (aid != other.aid)
//			return false;
//		return true;
//	}
//
//	@Override
//	public String toString() {
//		return "Address [aid=" + aid + ", city=" + city + ", citizen=" + citizen + "]";
//	}
//	
//	@Override
//	public int compareTo(Address o) {
//		return Integer.compare(this.aid, o.aid);
//	}
//}

package com.encora.model.onetoone;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Address implements Serializable, Comparable<Address> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aid;

	private String city;

	@OneToOne(mappedBy = "address")
	private Citizen citizen;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Citizen getCitizen() {
		return citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	@Override
	public String toString() {
		return "Address [aid=" + aid + ", city=" + city + ", citizen=" + citizen + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(aid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return aid == other.aid;
	}

	@Override
	public int compareTo(Address a) {
		return Integer.compare(this.aid, a.aid);
	}
}
