package com.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Book;
import com.jsp.service.BookService;

@WebServlet("/booksave")
public class Savebook extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String bname=req.getParameter("bname");
		String authorname=req.getParameter("authorname");
		
		Book book=new Book();
		book.setBook_name(bname);
		book.setAuthor_name(authorname);
		
		BookService bookService=new BookService();
		bookService.saveBook(book);
		
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("libHome.jsp");
		requestDispatcher.forward(req, resp);
		
		
		
	}

}
