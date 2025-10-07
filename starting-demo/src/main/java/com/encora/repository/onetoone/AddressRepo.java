package com.encora.repository.onetoone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.encora.model.onetoone.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer>{

}
