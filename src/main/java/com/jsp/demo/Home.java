package com.jsp.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class Home extends HttpServlet {
	@Override
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String librarian=req.getParameter("librarian");
		String student=req.getParameter("student");
		
		if (librarian != null) {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("librarian.jsp");
			requestDispatcher.forward(req, resp);
		}
		else if(student != null) {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("student.jsp");
			requestDispatcher.forward(req, resp);
		}
		else {
			return;
		}
	}
}
 