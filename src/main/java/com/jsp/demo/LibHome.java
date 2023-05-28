package com.jsp.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/libHome")
public class LibHome extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String book = req.getParameter("book");
		String issueBook = req.getParameter("issueBook");

		if (book != null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("book.jsp");
			requestDispatcher.forward(req, resp);
		} else if (issueBook != null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("issueBook.jsp");
			requestDispatcher.forward(req, resp);
		} else
			return;

	}

}
