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
@WebServlet("/update")
public class UpdateLibrarian extends HttpServlet {
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
	 String lid=req.getParameter("id");
	 String oldpassword=req.getParameter("opassword");
	 String newpassword=req.getParameter("npassword");
	 
	 int id=Integer.parseInt(lid);
	 
	 LibrarianService librarianService=new LibrarianService();
	 Librarian librarian=librarianService.getByIdLibrarian(id);
	 if(librarian.getPassword().equals(oldpassword)) {
		 librarian.setPassword(newpassword);
		 librarianService.updateLibrarian(librarian, id);
		 RequestDispatcher requestDispatcher=req.getRequestDispatcher("home.jsp");
		 requestDispatcher.forward(req, resp);
		 
	 }
	 else {
		 RequestDispatcher requestDispatcher=req.getRequestDispatcher("update.jsp");
		 requestDispatcher.include(req, resp);
	 }
	 
}
	
}
