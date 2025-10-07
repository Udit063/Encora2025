package com.shopping.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.model.User;
import com.shopping.respository.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	public UserRepo userRepo;
	
	@Override
	public boolean checkFlag(String uname) throws Exception {
		User user = userRepo.findByUsername(uname);
		
		return Optional.ofNullable(user).map(u->u.getFlag()==1).orElseThrow(()->new IllegalArgumentException());
	}
	
	@Override
	public void updateFlag(String uname, int flag) {
		// TODO Auto-generated method stub
		User user = userRepo.findByUsername(uname);
		if(user == null) throw new IllegalArgumentException(); 
		user.setFlag(flag);
//		user.setUserid(user.getUserid());
		userRepo.save(user);		
		
	}
	
	@Override
	public boolean checkUser(String uname, String upass) {
		// TODO Auto-generated method stub
		User user = userRepo.findByUsername(uname);
		System.out.println(user+"!23");
		if(user==null) return false;
		if(user.getUserpass().equals(upass)) {
			return true;
		}
		return false;
	}
	
	@Override
	public void insert(String uname, String upass) {
		User user = new User(uname, upass);
		userRepo.save(user);
	} 
		
	
}
