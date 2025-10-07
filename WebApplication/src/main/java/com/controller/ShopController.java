package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Bill;
import com.model.Items;
import com.model.ShopItem;
import com.model.User;
import com.repository.BillRepo;
import com.repository.ItemsRepo;
import com.service.ItemsService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/shop")
public class ShopController {
	@Autowired
	ItemsService itemService;

	@Autowired
	BillRepo billRepo;

	@RequestMapping(method = RequestMethod.GET, value = "/electronics")
	public ModelAndView electronicShop() {
		ModelAndView mandv = new ModelAndView();
		List<Items> itemsList = itemService.findByCategories(Items.Category.Electronics);
		System.out.println("items list" + itemsList);
		mandv.addObject("itemsList", itemsList);
		mandv.addObject("shopObj", new ShopItem());
		mandv.addObject("categoryName", Items.Category.Electronics);
		mandv.setViewName("shop");
		return mandv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/food")
	public ModelAndView foodShop() {
		ModelAndView mandv = new ModelAndView();
		List<Items> itemsList = itemService.findByCategories(Items.Category.Food);
		System.out.println("items list" + itemsList);
		mandv.addObject("itemsList", itemsList);
		mandv.addObject("shopObj", new ShopItem());
		mandv.addObject("categoryName", Items.Category.Food);
		mandv.setViewName("shop");
		return mandv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/beverages")
	public ModelAndView beverageShop() {
		ModelAndView mandv = new ModelAndView();
		List<Items> itemsList = itemService.findByCategories(Items.Category.Beverages);
		System.out.println("items list" + itemsList);
		mandv.addObject("itemsList", itemsList);
		mandv.addObject("shopObj", new ShopItem());
		mandv.addObject("categoryName", Items.Category.Beverages);
		mandv.setViewName("shop");
		return mandv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/cart")
	public ModelAndView selectItems(@ModelAttribute("shopObj") ShopItem selectedItemIds, HttpSession session) {
		System.out.println("itemssssss: " + selectedItemIds);
		List<Items> selectedItem = (List<Items>) itemService.findBySelectedIds(selectedItemIds.getSelectedItemIds());
		System.out.println("selected items : " + selectedItem);
		List<Items> cartItems = (List<Items>) session.getAttribute("selected");
		if (cartItems != null) {
			for (Items i : selectedItem) {
				cartItems.add(i);
			}

			session.setAttribute("selected", cartItems);
		} else {
			session.setAttribute("selected", selectedItem);
		}
		ModelAndView mandv = new ModelAndView();
		mandv.setViewName("cart");
		return mandv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/invoice")
	public ModelAndView generateBill(@ModelAttribute("billObj") Bill bill, HttpSession session) {
		ModelAndView mandv = new ModelAndView();
		List<Items> selectedItems = (List<Items>) session.getAttribute("selected");
		List<Integer> selectedItemIds = new ArrayList<>();
		User user = (User) session.getAttribute("user");
		System.out.println("user in bill: "+user);
		System.out.println("user id in bill: "+user.getUid());
		if (user != null) {
			bill.setCustId(user.getUid());
		}
		for (Items i : selectedItems) {
			selectedItemIds.add(i.getItemId());
		}
		bill.setItemIds(selectedItemIds);
//		for (Items i : selectedItems) {
//		    i.setBill(bill);  // set owning side
//		}
//		bill.setItems(selectedItems);
//		billRepo.save(bill);

		billRepo.save(bill);
		mandv.addObject("billObj", bill);
		mandv.setViewName("invoice");
		System.out.println("Bill: " + bill);
		return mandv;

	}
}
