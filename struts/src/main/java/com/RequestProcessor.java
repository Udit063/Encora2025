package com;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.util.Properties;

import com.model.Action;

public class RequestProcessor  {
	public void doProcess(HttpServletRequest request, HttpServletResponse response) {
		try {
			ServletContext application = request.getServletContext();
			String realPath = application.getRealPath("/WEB-INF/config.properties");
			
			Properties prop = new Properties();
			prop.load(new FileInputStream(realPath));
			
			String action = request.getParameter("action");
			
			String actionClass = prop.getProperty(action);
			
			Action actionObj = (Action)Class.forName(actionClass).getConstructor().newInstance();
			
			String result = actionObj.execute(request, response);
			String nextPage = prop.getProperty(result);
			
			RequestDispatcher rd= request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
