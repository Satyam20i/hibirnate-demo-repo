package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.model.Person;
import com.lti.model.Project;

public class ProjectDao {
	
	EntityManager em;
	EntityManagerFactory emf;
	EntityTransaction tx;
	public void addAProject(Project project){
		emf=Persistence.createEntityManagerFactory("pu");
		
		em=emf.createEntityManager();
		
		tx=em.getTransaction();
		
		tx.begin();
		
		em.persist(project); // Add New Record in the Table which i DML operation this need to be done inside the trasaction 
		
		tx.commit();
	}
	public void addOrupdateProject(Project project) {
		emf = Persistence.createEntityManagerFactory("pu");

		em = emf.createEntityManager();

		tx = em.getTransaction();

		tx.begin();

		em.merge(project); // Add New Record in the Table which i DML operation
							// this need to be done inside the trasaction

		tx.commit();

	}
	public Project findAProjectById(int projectId) {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();

		return em.find(Project.class, projectId);
	}
	
	public List<Project> viwaAllProjects(){
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		String jpql = "select p from Project p";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	
	}
	public List<Project> findProjectByName(String projectName){
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		String jpql ="select p from Project p where p.projectName=:pName";
		Query query = em.createQuery(jpql);
		query.setParameter("pName",projectName);
		return query.getResultList();
		
	}
}
