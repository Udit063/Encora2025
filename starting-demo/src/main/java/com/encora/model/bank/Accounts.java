
package com.encora.model.bank;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Accounts implements Serializable, Comparable<Accounts> {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accNo;
	private int amount;
	
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(accNo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Accounts other = (Accounts) obj;
		return accNo == other.accNo;
	}
	@Override
	public String toString() {
		return "Accounts [accNo=" + accNo + ", amount=" + amount + "]";
	}
	@Override 
	public int compareTo(Accounts a) {
		return Integer.compare(this.accNo, a.accNo);
	}
}
