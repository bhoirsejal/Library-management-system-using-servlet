package com.jsp.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/student")
public class StudentButton extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String save = req.getParameter("save");
		String update = req.getParameter("update");
		String delete = req.getParameter("delete");
		String getAll = req.getParameter("getAll");
		String getById = req.getParameter("getById");

		if (save != null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("studsave.jsp");
			requestDispatcher.forward(req, resp);
		} else if (update != null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("studupdate.jsp");
			requestDispatcher.forward(req, resp);
		} else if (delete != null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("studentdelete.jsp");
			requestDispatcher.forward(req, resp);
		} else if (getAll != null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("studentgetAll.jsp");
			requestDispatcher.forward(req, resp);
		} else if (getById != null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("studentgetById.jsp");
			requestDispatcher.forward(req, resp);
		} else
			return;
	}

}
