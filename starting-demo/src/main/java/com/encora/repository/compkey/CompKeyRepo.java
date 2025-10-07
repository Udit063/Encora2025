package com.encora.repository.compkey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.encora.model.compkey.CompKey;
import com.encora.model.compkey.ItemTransaction;

@Repository
public interface CompKeyRepo extends JpaRepository<ItemTransaction,	CompKey> {

}
