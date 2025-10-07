package com.encora.repository.manytomany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.encora.model.manytomany.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
