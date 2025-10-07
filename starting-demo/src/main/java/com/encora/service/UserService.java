package com.encora.service;

import com.encora.exceptions.UserNotFoundException;

public interface UserService {
	public boolean checkUser(String uname, String upass);
	public boolean checkFlag(String uname)throws Exception;
	public void updateFlag(String uname, int flag);
	public void insert(String uname, String upass);
//	public boolean checkUserByNameAndPassword(String username, String userpass) throws UserNotFoundException;
}
