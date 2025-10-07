package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/bc3")
@SessionAttributes({"myobj"})
public class BasicController3 {
	@RequestMapping(method = RequestMethod.GET, value = "/basic")
	public String sayHelloBasic() {
		return "home";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	public String sayHello(HttpServletRequest request, Model model) {
		request.setAttribute("myobjrequest", "this is request added value");
		model.addAttribute("myobj", "this is session value added in hello1");
		model.addAttribute("myobjrequest2", "this is request second value");
		return "home";
	}
	
	
	// on adding session on the top, we don't need to declare request method, it will directly save the key value pair in the session automatically, no need to define again
	@RequestMapping(method = RequestMethod.GET, value = "/hello2")
	public String sayHello2(Model model) {
//		request.setAttribute("myobjrequest", "this is request added value");
		model.addAttribute("myobj", "this is session value added in hello1");
		model.addAttribute("myobjrequest2", "this is request second value");
		return "home";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/hello3")
	public ModelAndView sayHello3() {
		ModelAndView mandv = new ModelAndView();
		mandv.addObject("myobj", "this is obj value...");
		mandv.setViewName("home");
		return mandv;
	}
}
