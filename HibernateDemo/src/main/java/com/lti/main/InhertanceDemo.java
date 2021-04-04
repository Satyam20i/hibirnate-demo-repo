package com.lti.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.lti.model.Current;
import com.lti.model.Saving;

public class InhertanceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Saving saving1 = new Saving("1234", 10000, 5000, 4.5);
		Saving saving2 = new Saving("5678", 15000, 5000, 7.5);
		
		Current current = new Current("1111",10000,2000);
		Current current2 = new Current("2222",12000,4000);
		
		tx.begin();
		em.persist(saving1);
		em.persist(saving2);
		em.persist(current);
		em.persist(current2);
		
		tx.commit();
		em.close();
		emf.close();
		
	}

}
