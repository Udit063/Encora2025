package com.controller;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

public class CheckNumber extends TagSupport{
	String num;
	
	public void setNum(String num) {
		this.num=num;
	}
	public String getNum() {
		return this.num;
	}
	
	@Override
	public int doEndTag() throws JspException {
		int n=Integer.parseInt(num);
		JspWriter out=pageContext.getOut();
		if(n%2==0) {
			try {
				System.out.println("called....");
				out.println("even number....");
				out.write("even number.....");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				System.out.println("called.............odd");
				out.println("odd number....");
				out.write("odd number.....");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return 1;
	}
}