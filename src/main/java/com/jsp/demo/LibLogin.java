package com.jsp.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Librarian;
import com.jsp.service.LibrarianService;

@WebServlet("/librarianlogin")
public class LibLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String s_id = req.getParameter("id");
		String password = req.getParameter("password");

		int id = Integer.parseInt(s_id);

		LibrarianService librarianService = new LibrarianService();
		Librarian librarian = librarianService.getByIdLibrarian(id);

		if (id == librarian.getId() && password.equals(librarian.getPassword())) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("libHome.jsp");
			requestDispatcher.forward(req, resp);
		} else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("libLogin.jsp");
			requestDispatcher.include(req, resp);
		}

	}

}
