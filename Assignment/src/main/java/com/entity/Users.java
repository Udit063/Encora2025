package com.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {
	private String name;
	
	@Id
	private Long id;	
	
	public Users() {
	}
	
	public Users(Long id, String name)
	{
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + "]";
	}
	
	
}
