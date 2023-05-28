package com.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Librarian;
import com.jsp.service.LibrarianService;
@WebServlet("/save")
public class SaveLibrarian extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		
		Librarian librarian=new Librarian();
		librarian.setName(name);
		librarian.setPassword(password);
		
		LibrarianService librarianService=new LibrarianService();
		librarianService.saveLibrarian(librarian);
		
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("home.jsp");
		requestDispatcher.forward(req, resp);
		
	}
	

}
