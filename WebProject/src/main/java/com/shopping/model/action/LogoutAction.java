package com.shopping.model.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.service.UserServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component("logout")
public class LogoutAction extends Action{
	public LogoutAction() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private UserServiceImpl userService;
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
//		String upass = req.getParameter("upass");
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("uname");
		String uname=(String)obj;
		System.out.println(uname);
		if(uname!=null) {
			if(userService.checkFlag(uname)) {
				userService.updateFlag(uname, 0);
				session.removeAttribute("uname");
				return "logout.success";
			}
		}
		return "logout.failure";
	}
}
