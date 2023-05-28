package com.jsp.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/issueBook")
public class IssueBook extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String borrowbook=req.getParameter("borrowbook");
		String returnbook=req.getParameter("returnbook");
		
		if(borrowbook != null) {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("borrowbook.jsp");
			requestDispatcher.forward(req, resp);
		}
		else if(returnbook != null) {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("returnbook.jsp");
			requestDispatcher.forward(req, resp);
		}
		
	}
	

}
