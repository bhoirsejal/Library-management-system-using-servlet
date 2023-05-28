package com.jsp.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.Book;

public class BookDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("sejal");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	
	public Book saveBook(Book book) {
		entityTransaction.begin();
		entityManager.persist(book);
		entityTransaction.commit();
		return book;
	}
	public Book getByIdBook(int id) {
		return entityManager.find(Book.class, id);
	}
	
	public List<Book> getAllBooks(){
		String sql="select b from Book b";
		Query query=entityManager.createQuery(sql);
		List<Book> books=query.getResultList();
		return books;
	}

}



