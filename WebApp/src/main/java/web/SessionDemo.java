package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/SessionDemo")
public class SessionDemo extends HttpServlet {
	int count=0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream out = response.getOutputStream();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		
		// Only once and next time, it will retreive
		Object obj = session.getAttribute("counter");
		
		// If cookies are blocked then we use this method, by accepting the permission
		String encodeUrl = response.encodeURL("SessionDemo");
		out.println("<br><a href='"+encodeUrl+"'> Click to refresh with Session Track</a><br>");
		
		Cookie cookie = new Cookie("mypassword", "2345678%2");
		response.addCookie(cookie);
		
		Cookie cc[] = request.getCookies();
		for(Cookie ccc:cc) {
			System.out.println(ccc.getName());
			System.out.println(ccc.getValue());
		}
		
		if(obj==null) {
			out.println("<h1>Welcome for the first time...");
			session.setAttribute("counter", ++count);
		} else {
			int c = Integer.parseInt(obj.toString());
			out.println("You are visiting : " + c + " times...");
			session.setAttribute("counter", ++c);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
