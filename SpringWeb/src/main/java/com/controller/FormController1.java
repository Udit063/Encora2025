package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/form1")
public class FormController1 {	
	@RequestMapping(method=RequestMethod.GET, value="/register")
	public ModelAndView loadForm() {
		ModelAndView mandv = new ModelAndView();
		mandv.addObject("userObj", new User());
		mandv.setViewName("userform");
		return mandv;
	}
	
	@RequestMapping(method=RequestMethod.POST, value ="/register")
	public ModelAndView processForm(@Valid @ModelAttribute("userObj") User user, BindingResult result)
	{
		ModelAndView mandv = new ModelAndView();
		if(result.hasErrors()) {
			mandv.setViewName("userform");
		} else {
			System.out.println("username : " + user.getUname());
			user.setUname(user.getUname()+ " encora Technologies");
			mandv.addObject("myuser", user.getUname());
			mandv.setViewName("welcome");
		}
		return mandv;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/mytag")
	public ModelAndView getMyTag() {
		ModelAndView mandv = new ModelAndView();
		mandv.addObject("number", "100");
		mandv.setViewName("mytag");
		return mandv;
	}
}
