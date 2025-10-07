package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.model.User;
import com.repository.UserRepo;
import com.service.LoginService;
import com.service.LogoutServiceImpl;
import com.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
@SessionAttributes("userObj")
public class UserController {
	@Autowired
	UserService userService;

	@Autowired
	UserRepo userRepo;

	@Autowired
	LoginService loginService;

	@Autowired
	LogoutServiceImpl logoutService;

	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public ModelAndView loadLoginForm() {
		ModelAndView mandv = new ModelAndView();
		mandv.addObject("userObj", new User());
		mandv.setViewName("login");
		return mandv;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/register")
	public ModelAndView loadRegisterForm() {
		ModelAndView mandv = new ModelAndView();
		mandv.addObject("userObj", new User());
		mandv.setViewName("register");
		return mandv;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/home")
	public String loadHome(HttpSession session) {
		session.removeAttribute("selected");
		session.removeAttribute("billObj");
		return "welcome";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/welcome")
	public String loadWelcome() {
		return "welcome";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/welcome")
	public ModelAndView login(@Valid @ModelAttribute("userObj") User user, BindingResult result, HttpSession session) {
		ModelAndView mandv = new ModelAndView();
		if (result.hasErrors()) {
			mandv.setViewName("login");
		} else {
			System.out.println("user : " + user);
			mandv.addObject("userObj", user);
			String view = loginService.doProcess(user.getUname(), user.getUpass(), session);
			mandv.setViewName(view);
		}
		return mandv;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public ModelAndView register(@Valid @ModelAttribute("userObj") User user, BindingResult result, HttpSession session) {
		ModelAndView mandv = new ModelAndView();
		if (result.hasErrors()) {
			mandv.setViewName("login");
		} else {
			System.out.println("user : " + user);
			userService.insertUser(user.getUname(), user.getUpass());
			mandv.setViewName("login");
		}
		return mandv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mandv = new ModelAndView();
		User user = (User) session.getAttribute("user");
		String users = user.getUname();

		if (users != null) {
			logoutService.doProcess(users);
			System.out.println("mandv : " + mandv);

		}
		if (session.getAttribute("user") != null) {
			session.invalidate();
		}
		mandv.setViewName("redirect:/register");
		return mandv;
	}
}
