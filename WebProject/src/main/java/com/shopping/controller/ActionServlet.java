package com.shopping.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;

@WebServlet("*.do")
public class ActionServlet extends HttpServlet {
	RequestProcessor rp;
	
    public ActionServlet() {
        rp=new RequestProcessor();
    }
    
    private ConfigurableApplicationContext ctx;
    
    public void setCtx(ConfigurableApplicationContext ctx) {
    	this.ctx = ctx;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rp.setCtx(ctx);
		rp.doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	

}
