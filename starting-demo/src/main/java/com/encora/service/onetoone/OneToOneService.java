//package com.encora.service.onetoone;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.encora.model.onetoone.Address;
//import com.encora.model.onetoone.Citizen;
//import com.encora.repository.onetoone.AddressRepo;
//import com.encora.repository.onetoone.CitizenRepo;
//
//@Service
//public class OneToOneService {
//	@Autowired
//	private AddressRepo addressTepo;
//	@Autowired
//	private CitizenRepo citizenRepo;
//	
//	public void insert() {
//		Citizen citizen=new Citizen();
//		citizen.setCname("ramu");
//		
//		Address add=new Address();
//		add.setCity("delhi");
//		
//		citizen.setAddress(add);
//		
//		citizenRepo.save(citizen);
//	}
//}

package com.encora.service.onetoone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encora.model.onetoone.Address;
import com.encora.model.onetoone.Citizen;
import com.encora.repository.onetoone.AddressRepo;
import com.encora.repository.onetoone.CitizenRepo;

@Service
public class OneToOneService{
	@Autowired
	private AddressRepo addressRepo;
	
	@Autowired
	private CitizenRepo citizenRepo;
	
	public void insert() {
		Citizen citizen = new Citizen();
		citizen.setCname("ramu");
		
		Address address = new Address();
		address.setCity("noida");
		
		citizen.setAddress(address);
		citizenRepo.save(citizen);
		
	}
}
