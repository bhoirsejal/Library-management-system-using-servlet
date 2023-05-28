package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.Book;
import com.jsp.dto.Student;

public class StudentDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sejal");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	//save student
	public Student saveStudent(Student student) {
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		return student;
	}
	//get by Id student
	public Student getByIdStudent(int id) {
		return entityManager.find(Student.class, id);
	}
	//update student
	public Student updateStudent(Student student) {
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
		return student;
	}
	//delete student
	public Student deleteStudent(Student student) {
		entityTransaction.begin();
		entityManager.remove(student);
		entityTransaction.commit();
		return student;
	}

	public List<Student> getAllStudents() {
		String sql = "select s from Student s";
		Query query = entityManager.createQuery(sql);
		List<Student> students=query.getResultList();
		return students;
	}
	//borrow book
	public boolean borrowBook(Student student, List<Book> books) {
		for (Book book : books) {
			if(student != null && book!=null) {
				entityTransaction.begin();
				entityManager.merge(student);
				entityManager.merge(book);
				entityTransaction.commit();
				System.out.println("Book Borrowed");
			}
			return true;
		}
		return false;
	}
	//Return Method
	
	public boolean returnBook(Student student, List<Book> books) {
		for (Book book : books) {
			if(student != null && book!=null) {
				entityTransaction.begin();
				entityManager.merge(student);
				entityManager.merge(book);
				entityTransaction.commit();
				System.out.println("Book Returned");
			}
			return true;
			
		}
		return false;
	}

}
