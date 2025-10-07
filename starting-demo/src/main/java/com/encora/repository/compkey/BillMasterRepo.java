package com.encora.repository.compkey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.encora.model.compkey.BillMaster;

@Repository
public interface BillMasterRepo extends JpaRepository<BillMaster, Integer> {

}
