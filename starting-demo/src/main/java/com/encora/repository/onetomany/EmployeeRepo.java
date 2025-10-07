package com.encora.repository.onetomany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.encora.model.onetomany.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
