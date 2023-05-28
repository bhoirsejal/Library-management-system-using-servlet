package com.jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Book;
import com.jsp.dto.Student;
import com.jsp.service.BookService;
import com.jsp.service.StudentService;
@WebServlet("/borrowbook")
public class BorrowBook extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id1=req.getParameter("sid");
		String id2=req.getParameter("bid");
		
		int sid=Integer.parseInt(id1);
		int bid=Integer.parseInt(id2);
		
		
		StudentService studentService=new StudentService();
		Student student= studentService.getByIdStudent(sid);
		
		BookService bookService=new BookService();
		List<Book> books=bookService.getAllBooks();
		
		for (Book book : books) {
			if(book.getId()==bid) {
				Book book2=bookService.getByIdBook(bid);
				book2.setStudent(student);
				
				List<Book> books2=new ArrayList<>();
				books2.add(book2);
				
				boolean flag= studentService.borrowBook(student, books2);
				if(flag==true) {
					RequestDispatcher requestDispatcher=req.getRequestDispatcher("libHome.jsp");
					requestDispatcher.forward(req, resp);
				}
				else {
					RequestDispatcher requestDispatcher=req.getRequestDispatcher("borrow.jsp");
					requestDispatcher.include(req, resp);
				}
			}
		}
	}
	

}
