package com.encora.repository.manytomany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.encora.model.manytomany.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {

}
