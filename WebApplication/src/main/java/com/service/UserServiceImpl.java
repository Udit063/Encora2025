package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.User;
import com.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;

	@Override
	public boolean checkFlag(String uname) {
		User user = userRepo.findByUname(uname);
		return Optional.ofNullable(user).map(u -> u.getFlag() == 1).orElse(false);
	}

	@Override
	public void updateFlag(String uname, int flag) {
		User user = userRepo.findByUname(uname);
		Optional.ofNullable(user).map(u -> {
			u.setFlag(flag);
			userRepo.save(user);
			return u;
		}).orElseThrow(() -> new IllegalArgumentException());
	}
	
	@Override
	public boolean checkUser(String uname, String upass) {
		User user = userRepo.findByUname(uname);
		return Optional.ofNullable(user).map(u -> u.getUpass().equals(upass)).orElse(false);
	}
	
	@Override
	public void insertUser(String uname, String upass) {
		User user = new User();
		user.setUname(uname);
		user.setUpass(upass);
		user.setFlag(0);
		userRepo.save(user);
	}
	
}
