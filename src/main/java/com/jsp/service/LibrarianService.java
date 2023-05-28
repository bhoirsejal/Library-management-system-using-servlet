package com.jsp.service;

import java.util.List;

import com.jsp.dao.LibrarianDao;
import com.jsp.dto.Librarian;

public class LibrarianService {
	LibrarianDao librarianDao = new LibrarianDao();

	// save librarian
	public Librarian saveLibrarian(Librarian librarian) {
		return librarianDao.saveLibrarian(librarian);
	}

	// get by id librarian
	public Librarian getByIdLibrarian(int id) {
		return librarianDao.getByIdLibrarian(id);
	}

	// update librarian
	public Librarian updateLibrarian(Librarian librarian, int id) {
		Librarian librarian2 = librarianDao.getByIdLibrarian(id);
		if (librarian.getPassword() != null) {
			librarian2.setPassword(librarian.getPassword());
		}
		return librarianDao.updateLibrarian(librarian2);
	}

	public Librarian deleteLibrarian(int id) {
		Librarian librarian = librarianDao.getByIdLibrarian(id);
		return librarianDao.deleteLibrarian(librarian);
	}

	public List<Librarian> getAllLibrarians() {
		return librarianDao.getAllLibrarians();
	}
}
