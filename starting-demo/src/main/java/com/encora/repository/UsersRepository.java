package com.encora.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.encora.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, UUID> {
	// JPA will automatically create a service, needed, the parameter should be passed like Username
	public Users findByUsername(String username);
	public Users findTopByOrderByUseridDesc();
	public Users findByUsernameAndUserpass(String uname, String upass);
}