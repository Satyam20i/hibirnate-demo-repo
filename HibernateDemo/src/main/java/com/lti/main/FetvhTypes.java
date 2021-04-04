package com.lti.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.lti.model.Album;
import com.lti.model.Person;
import com.lti.model.Song;

public class FetvhTypes {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		/*Person person = em.find(Person.class,10);
		System.out.println(person.getPersonName());*/
		
		Album album = em.find(Album.class,2023);
		List<Song> songs = album.getSongs();
		for(Song s:songs){
			System.out.println(s.getTitle());
		}

	}

}
