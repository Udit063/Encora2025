package com.encora.repository.onetoone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.encora.model.onetoone.Citizen;

@Repository
public interface CitizenRepo extends JpaRepository<Citizen, Integer>{

}
