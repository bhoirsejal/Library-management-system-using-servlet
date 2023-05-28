package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.Librarian;

public class LibrarianDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sejal");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	// save method
	public Librarian saveLibrarian(Librarian librarian) {
		if (librarian != null) {
			entityTransaction.begin();
			entityManager.persist(librarian);
			entityTransaction.commit();
			return librarian;
		}
		return null;
	}

	// get by id method
	public Librarian getByIdLibrarian(int id) {
		return entityManager.find(Librarian.class, id);
	}

	public Librarian updateLibrarian(Librarian librarian) {
		entityTransaction.begin();
		entityManager.merge(librarian);
		entityTransaction.commit();
		return librarian;
	}

	public Librarian deleteLibrarian(Librarian librarian) {
		entityTransaction.begin();
		entityManager.remove(librarian);
		entityTransaction.commit();
		return librarian;
	}

	public List<Librarian> getAllLibrarians() {
		String sql = "select l from Librarian l";
		Query query = entityManager.createQuery(sql);
		List<Librarian> librarians = query.getResultList();
		return librarians;
	}

}
