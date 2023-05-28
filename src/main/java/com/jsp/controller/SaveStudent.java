package com.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Student;
import com.jsp.service.StudentService;
@WebServlet("/studsave")
public class SaveStudent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		
		Student student=new Student();
		student.setName(name);
		student.setEmail(email);
		
		
		StudentService studentService=new StudentService();
		studentService.saveStudent(student);
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("home.jsp");
		requestDispatcher.forward(req, resp);
		
	}

}
