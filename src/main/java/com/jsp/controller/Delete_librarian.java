package com.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.service.LibrarianService;
@WebServlet("/librariandelete")
public class Delete_librarian extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String lid=req.getParameter("id");
		int id=Integer.parseInt(lid);
		
		LibrarianService librarianService=new LibrarianService();
		librarianService.deleteLibrarian(id);
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("home.jsp");
		requestDispatcher.forward(req, resp);
	}

}
