package com.encora.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encora.model.Users;
import com.encora.repository.UsersRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UsersRepository userrepo;
	
	@Override
	public boolean checkFlag(String uname)throws Exception {
		// TODO Auto-generated method stub
		Users user = userrepo.findByUsername(uname);
//		if(user == null) throw new IllegalArgumentException();
//		if(user.getFlag() == 1) {
//			return true;
//		} else {
//			return false;			
//		}
		return Optional.ofNullable(user).map(u -> u.getFlag() == 1).orElseThrow(() -> new IllegalArgumentException());
	}
	
	@Override
	public void updateFlag(String uname, int flag) {
		// TODO Auto-generated method stub
		Users user = userrepo.findByUsername(uname);
		if(user == null) throw new IllegalArgumentException(); 
		user.setFlag(flag);
//		user.setUserid(user.getUserid());
		userrepo.save(user);		
		
	}
	
	@Override
	public boolean checkUser(String uname, String upass) {
		// TODO Auto-generated method stub
		Users user = userrepo.findByUsername(uname);
		System.out.println(user+"!23");
		if(user==null) return false;
		if(user.getUserpass().equals(upass)) {
			return true;
		}
		return false;
	}
	
	@Override
	public void insert(String uname, String upass) {
		Users user = new Users(uname, upass);
		userrepo.save(user);
	} 
		
	
	}
	
//	@Override
//	public boolean checkUserByNameAndPassword(String username, String userpass) throws UserNotFoundException{
//		Optional.ofNullable((userrepo.findByUsernameAndUserpass(username, userpass))
//				.map(n->true)
//				.orElseThrow(()->new UsernameNotFoundException("Invalid Credentials"));
//	}
//}
