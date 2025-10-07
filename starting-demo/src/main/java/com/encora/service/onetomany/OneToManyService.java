//package com.encora.service.onetomany;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.encora.model.onetomany.Department;
//import com.encora.model.onetomany.Employee;
//import com.encora.repository.onetomany.DepartmentRepo;
//import com.encora.repository.onetomany.EmployeeRepo;
//
//@Service
//public class OneToManyService {
//	@Autowired
//	private EmployeeRepo employeeRepo;
//	
//	@Autowired
//	private DepartmentRepo departmentRepo;
//	
//	public void create() {
//		Employee emp1 = new Employee();
//		emp1.setEname("ramu");
//		
//		Employee emp2 = new Employee();
//		emp2.setEname("somu");
//		
//		Department accounts = new Department();
//		accounts.setDname("Accounts...");
//		
//		emp1.setDepartment(accounts);
//		emp2.setDepartment(accounts);
//		
//		departmentRepo.save(accounts);
//		employeeRepo.save(emp1);
//		employeeRepo.save(emp2);
//	}
//}

package com.encora.service.onetomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encora.model.onetomany.Department;
import com.encora.model.onetomany.Employee;
import com.encora.repository.onetomany.DepartmentRepo;
import com.encora.repository.onetomany.EmployeeRepo;

@Service
public class OneToManyService{
	@Autowired
	private DepartmentRepo departmentRepo;
	
	@Autowired
	private EmployeeRepo empRepo;
	
	public void create() {
		Department d = new Department();
		d.setDname("Accounts...");
		
		Employee emp1 = new Employee();
		emp1.setDepartment(d);
		
		Employee emp2 = new Employee();
		emp2.setDepartment(d);
		
		departmentRepo.save(d);
		empRepo.save(emp1);
		empRepo.save(emp2);
	}
}