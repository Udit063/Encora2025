package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.model.Items;
import com.service.ItemsService;

@Controller
@RequestMapping("/items")
@SessionAttributes("itemsObj")
public class ItemsController {
	
	@Autowired
	ItemsService itemService;
	
	@RequestMapping(method = RequestMethod.GET, value="/addItems")
	public ModelAndView processForm() {
		ModelAndView mandv = new ModelAndView();
		mandv.addObject("itemsObj", new Items());
		mandv.setViewName("addItems");
		return mandv;
	}	
	
	@RequestMapping(method = RequestMethod.POST, value = "/addItems")
	public ModelAndView addItems(@ModelAttribute("itemsObj")Items item, BindingResult result) {
		ModelAndView mandv = new ModelAndView();
		if(result.hasErrors()) {
			mandv.setViewName("welcome");
			return mandv;
		}
		mandv.addObject("itemsObj", item);
		itemService.addItems(item);
		mandv.setViewName("welcome");
		return mandv;
	}
}
