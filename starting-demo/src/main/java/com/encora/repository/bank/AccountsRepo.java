package com.encora.repository.bank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.encora.model.bank.Accounts;

@Repository
public interface AccountsRepo extends JpaRepository<Accounts, Integer> {
}
