package com.encora.service.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encora.model.manytomany.Course;
import com.encora.model.manytomany.Student;
import com.encora.repository.manytomany.CourseRepo;
import com.encora.repository.manytomany.StudentRepo;

@Service
public class ManyToManyService {
	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private CourseRepo courseRepo;

	public void insert() {
		Course c1 = new Course();
		c1.setCname("Java");

		Course c2 = new Course();
		c2.setCname("Dot net");

		Student s1 = new Student();
		s1.setSname("ramu");

		Student s2 = new Student();
		s2.setSname("somu");

		List<Course> courses = new ArrayList<>();
		courses.add(c1);
		courses.add(c2);

		s1.setCourse(courses);

		studentRepo.save(s1);
//		courseRepo.save(c1);
//		courseRepo.save(c2);

	}
}
