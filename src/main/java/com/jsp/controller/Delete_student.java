package com.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.service.StudentService;
@WebServlet("/studentdelete")
public class Delete_student extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sid=req.getParameter("id");
		int id=Integer.parseInt(sid);
		
		StudentService studentService=new StudentService();
		studentService.deleteStudent(id);
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("home.jsp");
		requestDispatcher.forward(req, resp);
	}
}
