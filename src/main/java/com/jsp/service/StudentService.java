package com.jsp.service;

import java.util.List;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Book;
import com.jsp.dto.Student;

public class StudentService {
	StudentDao studentDao = new StudentDao();

	public Student saveStudent(Student student) {
		return studentDao.saveStudent(student);
	}

	public Student getByIdStudent(int id) {
		return studentDao.getByIdStudent(id);
	}

	public Student updateStudent(Student student, int id) {
		Student student2 = studentDao.getByIdStudent(id);
		if (student.getEmail() != null) {
			student2.setEmail(student.getEmail());
		}
		return studentDao.updateStudent(student2);
	}

	public Student deleteStudent(int id) {
		Student student = studentDao.getByIdStudent(id);
		return studentDao.deleteStudent(student);
	}
	//get All students

	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}
	//borrow book
	public boolean borrowBook(Student student, List<Book> books) {
		return studentDao.borrowBook(student, books);
	}
	//return book
	public boolean  returnBook(Student student,List<Book> books) {
		return studentDao.returnBook(student, books);
	}

}
