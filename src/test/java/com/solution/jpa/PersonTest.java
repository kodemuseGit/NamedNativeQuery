package com.solution.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.BeforeClass;
import org.junit.Test;

import com.solution.jpa.dao.PersonDao;
import com.solution.jpa.dto.Person;
import com.solution.jpa.entity.PersonEntity;

public class PersonTest {

	private static EntityManagerFactory emFactory;

	@BeforeClass
	public static void setEntityManagerFactory() {
		setEmFactory(PersonDao.getInstance().getEmFactory());
	}

	@Test
	public void getPerson() {
		EntityManager entityManager = getEmFactory().createEntityManager();
		List<PersonEntity> persons = entityManager.createNamedQuery("fetch_person").getResultList();
		System.out.println(persons.size());
	}

	@Test
	public void getPersonName() {
		EntityManager entityManager = getEmFactory().createEntityManager();
		List<String> persons = entityManager.createNamedQuery("fetch_person_name").getResultList();
		for (String person : persons) {
			System.out.println("name = " + person);
		}
	}

	@Test
	public void getPersonNameCode() {
		EntityManager entityManager = getEmFactory().createEntityManager();
		List<Object[]> persons = entityManager.createNamedQuery("fetch_person_name_code").getResultList();
		System.out.println(persons.size());
		for (Object[] person : persons) {
			System.out.println("name = " + person[0] + ", " + person[1]);
		}
	}

	@Test
	public void getPersonNameCodeInDTO() {
		EntityManager entityManager = getEmFactory().createEntityManager();
		List<Person> persons = entityManager.createNamedQuery("fetch_person_name_dto").getResultList();
		System.out.println(persons.size());
		for (Person person : persons) {
			System.out.println("name = " + person.toString());
		}
	}

	public static EntityManagerFactory getEmFactory() {
		return emFactory;
	}

	public static void setEmFactory(EntityManagerFactory emFactory) {
		PersonTest.emFactory = emFactory;
	}
}
