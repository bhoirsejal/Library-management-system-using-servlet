package com.jsp.service;

import java.util.List;

import com.jsp.dao.BookDao;
import com.jsp.dto.Book;

public class BookService {
	BookDao bookDao = new BookDao();

	public Book saveBook(Book book) {
		return bookDao.saveBook(book);
	}

	public Book getByIdBook(int id) {
		return bookDao.getByIdBook(id);
	}

	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}

}
