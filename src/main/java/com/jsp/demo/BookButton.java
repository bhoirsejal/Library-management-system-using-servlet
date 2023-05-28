package com.jsp.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/book")
public class BookButton extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String save = req.getParameter("save");

		String getAll = req.getParameter("getAll");
		String getById = req.getParameter("getById");

		if (save != null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("booksave.jsp");
			requestDispatcher.forward(req, resp);

		} else if (getAll != null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("bookgetAll.jsp");
			requestDispatcher.forward(req, resp);
		} else if (getById != null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("bookgetById.jsp");
			requestDispatcher.forward(req, resp);
		} else
			return;
	}

}
