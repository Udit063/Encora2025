package web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


/*
 * Either I can use a reference name to call this file using webApp in action in Hello.html
 * Or I can use *.encora or *.com anything, which means, this class will get called every time whenever there is (something).encora or (something).com, but I have to add the context path in my action in html file
 */
// @WebServlet("/webApp")
@WebServlet("*.encora")
public class webApp extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("do get called....");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		System.out.println("do post called...");
//		HttpSession session = request.getSession();
		
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		System.out.println(uname + " : " + upass);
		
		ServletContext application = request.getServletContext();
		application.setAttribute("myname", uname);
		
		// Redirecting the client to a webpage		
		if(uname.equals("ramu")) {
			response.sendRedirect("SecondServlet");
//			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
//			rd.forward(request, response);
		} else {
			
			/*
			 * The difference between redirect and RequestDispatcher
			 * In redirect, it will take 2 calls, as it will first go to the servlet with a request and get a response. It will get a url in response and then it will redirects it, hence calling 2 calls
			 * In RequestDispatcher, the response will directly go with the conditions you had entered (welcome/register) and the response will get back to the browser, hence, calling single api without changing the url and much faster
			 */
			
			response.sendRedirect("register.jsp");
//			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
//			rd.forward(request, response);
		}
	}

}
