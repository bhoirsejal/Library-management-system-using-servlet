package com.jsp.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/admin")
public class Admin extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		if(name.equals("sejal") && password.equals("sejal123")) {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("home.jsp");
			requestDispatcher.forward(req, resp);
		}
		else {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("adminLogin.jsp");
			requestDispatcher.include(req, resp);
		}
	}
	

}
