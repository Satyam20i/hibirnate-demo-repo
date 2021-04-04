package com.lti.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.lti.model.Person;

public class EntityStateDemo {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Person person = new Person();
		person.setPersonName("Sharad");
		person.setPersonAge(22);
		person.setPersonCity("Pune");
		tx.begin();
		 em.persist(person); //this person object in now in persistence context and the is in persistence 
		 //manged state
		 tx.commit(); //inserts the object into database table.
		 em.close();//you are out of persistence context
		 
		 tx.begin();
		 em.merge(person); //back to persistence context
		 tx.commit(); 
		 
	}

}
