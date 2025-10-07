package com.shopping.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.model.Bill;

@Repository
public interface BillRepo extends JpaRepository<Bill, Integer> {

}
