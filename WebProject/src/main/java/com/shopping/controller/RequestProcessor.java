package com.shopping.controller;

import java.io.FileInputStream;
import java.util.Properties;

import org.springframework.context.ConfigurableApplicationContext;

import com.shopping.model.action.Action;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RequestProcessor {
	private ConfigurableApplicationContext ctx;
	
	public void setCtx(ConfigurableApplicationContext ctx) {
		this.ctx = ctx;
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) {
		try {
			ServletContext application = request.getServletContext();
			String realPath = application.getRealPath("/WEB-INF/lib/config.properties");
			System.out.println(realPath + " -> hello path");
			
			Properties prop = new Properties();
			prop.load(new FileInputStream(realPath));
			
			String action = request.getParameter("action");
			System.out.println("The action is : " + action);
			
			if(action == null) {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				Action actionObj = (Action)ctx.getBean(action);			
				String result = actionObj.execute(request, response);
				String nextPage = prop.getProperty(result);
				
				RequestDispatcher rd = request.getRequestDispatcher(nextPage);
				rd.forward(request, response);
				
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
