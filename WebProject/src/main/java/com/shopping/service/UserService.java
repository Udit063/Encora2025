package com.shopping.service;

public interface UserService {
	public boolean checkUser(String uname, String upass);
	public boolean checkFlag(String uname)throws Exception;
	public void updateFlag(String uname, int flag);
	public void insert(String uname, String upass);
}
