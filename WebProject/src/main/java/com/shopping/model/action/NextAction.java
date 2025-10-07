package com.shopping.model.action;

import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("next")
public class NextAction extends Action {
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		return "next.success";
	}
}
