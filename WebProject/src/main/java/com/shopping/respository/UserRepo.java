package com.shopping.respository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, UUID> {
	public User findByUsername(String username);
	public User findTopByOrderByUseridDesc();
	public User findByUsernameAndUserpass(String uname, String upass);
}
