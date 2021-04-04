package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.lti.model.Aadhar;
import com.lti.model.Passport;
import com.lti.model.Person;

public class PersonDao {

	EntityManager em;
	EntityManagerFactory emf;
	EntityTransaction tx;

	/*
	 * public void addAPerson(Person person){
	 * emf=Persistence.createEntityManagerFactory("pu");
	 * 
	 * em=emf.createEntityManager();
	 * 
	 * tx=em.getTransaction();
	 * 
	 * tx.begin();
	 * 
	 * em.persist(person); // Add New Record in the Table which i DML operation
	 * this need to be done inside the trasaction
	 * 
	 * tx.commit();
	 * 
	 * 
	 * }
	 */
	public void addOrupdatePerson(Person person) {
		emf = Persistence.createEntityManagerFactory("pu");

		em = emf.createEntityManager();

		tx = em.getTransaction();

		tx.begin();

		em.merge(person); // Add New Record in the Table which i DML operation
							// this need to be done inside the trasaction

		tx.commit();

	}

	public Person findAPersonById(int personId) {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();

		return em.find(Person.class, personId);
	}
/*	public List<Person> viwaAllPersons(){
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		String jpql = "select p from Person p";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	
	}*/
	public List<Person> findPersonByName(String personName){
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		String jpql ="select p from Person p where p.personName=:pName";
		Query query = em.createQuery(jpql);
		query.setParameter("pName",personName);
		return query.getResultList();
		
	}
	public void addPersonWithPassport(Person person){
		//addOrupdatePerson(person);
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		
		tx=em.getTransaction();
		
		
		tx.begin();
		em.merge(person);
		tx.commit();
	}
	
	public void addPassportWithPerson(Passport passport){
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx=em.getTransaction();
		tx.begin();
			em.merge(passport);
		tx.commit();
	}
	
	public void addPersonWithAadhar(Person person){
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
			em.merge(person);
		tx.commit();
		
	}
	public void addAadharrWithPerson(Aadhar aadhar){
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
		tx.begin();
			
			em.merge(aadhar);
		tx.commit();
		
	}
	public List<Aadhar> viewAllAadhars(){
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		String jpql = "select a from Aadhar a";
		TypedQuery<Aadhar> query = em.createQuery(jpql,Aadhar.class);
		return query.getResultList();
	}
	public Aadhar findAadharByNo(int aadharNo){
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
		return em.find(Aadhar.class, aadharNo);
		
	}
	public Person findPersonByAadharNo(int aadharNo){
		Aadhar aadhar = findAadharByNo(aadharNo);
		return aadhar!=null?aadhar.getPerson():null;
		
	}
	
	public boolean hasAadharAllocated(int personId){
		Person person = findAPersonById(personId);
		if(person.getAadhar()==null){
			return false;
		}
		else{
			return true;
		}
	}
	
}
