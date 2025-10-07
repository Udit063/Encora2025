//package com.encora.model.onetomany;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
//
//@Entity
//public class Department implements Serializable, Comparable<Department> {
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private int did;
//	private String dname;
//	
//	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
//	private List<Employee> employees = new ArrayList<>();
//
//	public int getDid() {
//		return did;
//	}
//
//	public void setDid(int did) {
//		this.did = did;
//	}
//
//	public String getDname() {
//		return dname;
//	}
//
//	public void setDname(String dname) {
//		this.dname = dname;
//	}
//
//	public List<Employee> getEmployees() {
//		return employees;
//	}
//
//	public void setEmployees(List<Employee> employees) {
//		this.employees = employees;
//	}
//
//	@Override
//	public String toString() {
//		return "Department [did=" + did + ", dname=" + dname + ", employees=" + employees + "]";
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + did;
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
//		Department other = (Department) obj;
//		return did == other.did;
//	}
//	
//	
//	@Override
//	public int compareTo(Department d) {
//		return Integer.compare(this.did, d.did);
//	}
//
//}

package com.encora.model.onetomany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department implements Serializable, Comparable<Department>{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int did;
	
	private String dname;
	
	// if the department got deleted then employee will also got deleted, that's why we use cascade here
	// mapped by will not be on the owner side, it will give the entity field to look at
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	private List<Employee> emp = new ArrayList<>();

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public List<Employee> getEmp() {
		return emp;
	}

	public void setEmp(List<Employee> emp) {
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "Department [did=" + did + ", dname=" + dname + ", emp=" + emp + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(did);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return did == other.did;
	}
	
	public int compareTo(Department d) {
		return Integer.compare(this.did, d.did);
	}
	
}