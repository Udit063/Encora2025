package com.service;

public interface UserService {
	public boolean checkFlag(String uname);
	public void updateFlag(String uname, int flag);
	public boolean checkUser(String uname, String upass);
	public void insertUser(String uname, String upass);
}
