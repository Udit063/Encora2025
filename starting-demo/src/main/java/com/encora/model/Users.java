package com.encora.model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users implements Serializable {
	private static int id=(int)Math.random();
	@Id  // one should be id, these 2 annotations - Id and Entity should be minimal
	private UUID userid;
	
	private String username;
	private String userpass;
	private int flag;
	private int amt;
	public Users() {}
	public Users(String username, String userpass) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.userpass = userpass;
		this.userid = UUID.randomUUID();
		this.amt = 50000;
		this.flag = 0;
	}
	
	public UUID getUserid() {
		return userid;
	}
	public void setUserid(UUID userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
	}
}
