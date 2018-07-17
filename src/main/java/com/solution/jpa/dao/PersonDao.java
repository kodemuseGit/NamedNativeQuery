package com.solution.jpa.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersonDao {

	private static PersonDao instance;
	private EntityManagerFactory emFactory;

	public EntityManagerFactory getEmFactory() {
		return emFactory;
	}

	private PersonDao() {
		emFactory = Persistence.createEntityManagerFactory("JPAServices");
	}

	public static PersonDao getInstance() {
		if (instance == null) {
			instance = new PersonDao();

		}

		return instance;
	}

}
