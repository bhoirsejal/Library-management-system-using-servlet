package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Book;
import com.jsp.service.BookService;

@WebServlet("/bookgetById")
public class Get_By_Id_Book extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bid = req.getParameter("id");
		int id = Integer.parseInt(bid);

		BookService bookService = new BookService();
		Book book = bookService.getByIdBook(id);

		PrintWriter printWriter = resp.getWriter();
		printWriter.write("<html><head><body><h3> ID: " + book.getId() + "</h3> \n <h3>Book Name : " + book.getBook_name()
				+ "</h3> \n <h3>Author Name: " + book.getAuthor_name() + " </h3> </body></head></html>");
		printWriter.print("<a href='libHome.jsp'>Librarian Home Page</a>");
	}
}
