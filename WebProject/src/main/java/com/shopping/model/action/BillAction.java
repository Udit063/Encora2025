package com.shopping.model.action;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.model.Bill;
import com.shopping.model.User;
import com.shopping.respository.UserRepo;
import com.shopping.service.BillServiceImpl;
import com.shopping.service.UserServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component("bill")
public class BillAction extends Action {
	@Autowired
	private BillServiceImpl billServiceImpl;
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		User user = userRepo.findByUsernameAndUserpass("udit", "qwerty");
		
		HttpSession session = req.getSession();
		Enumeration<String> e = session.getAttributeNames();

		List<String> itemNames = new ArrayList<>();

		while (e.hasMoreElements()) {
			String name = e.nextElement();
			String value = (String)session.getAttribute(name);
			System.out.println("Item " + value);
			if (name != "uname") {
				itemNames.add(value);
			}

		}
		
		int billDetails = billServiceImpl.generateBill(itemNames, user);
		req.setAttribute("billdetails", billDetails);
		return "bill.success";
	}
}
