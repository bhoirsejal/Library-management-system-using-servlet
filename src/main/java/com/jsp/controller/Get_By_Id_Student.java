package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Student;
import com.jsp.service.StudentService;

@WebServlet("/studentgetById")
public class Get_By_Id_Student extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sid = req.getParameter("id");
		int id = Integer.parseInt(sid);
		StudentService studentService = new StudentService();
		Student student = studentService.getByIdStudent(id);
		PrintWriter printWriter = resp.getWriter();
		printWriter.write("<html><head><body><h3> ID: " + student.getId() + "</h3> \n <h3> Name : " + student.getName()
				+ "</h3> \n <h3>Email: " + student.getEmail() + " </h3></body></head></html>");
		printWriter.print("<a href='home.jsp'>Admin Home Page</a>");
	}
}
