package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Librarian;
import com.jsp.service.LibrarianService;

@WebServlet("/librariangetById")
public class Get_By_Id_Librarian extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String lid=req.getParameter("id");
			int id=Integer.parseInt(lid);
			
			LibrarianService librarianService=new LibrarianService();
			Librarian librarian=librarianService.getByIdLibrarian(id);
			PrintWriter printWriter=resp.getWriter();
			printWriter.write("<html><head><body><h3> ID: " + librarian.getId() + "</h3> \n <h3> Name : " + librarian.getName()
			+ "</h3> \n <h3>Password: " + librarian.getPassword() + " </h3></body></head></html>");
			
			printWriter.print("<a href='home.jsp'>Admin Home Page</a>");
			
	}
}
