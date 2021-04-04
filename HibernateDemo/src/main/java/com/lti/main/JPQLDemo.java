package com.lti.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.lti.model.Album;
import com.lti.model.Passport;
import com.lti.model.Person;
import com.lti.model.Song;

public class JPQLDemo {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		/*String jpql = "select count(p) from Person p where p.personCity=:city";
		
		TypedQuery<Long> query = em.createQuery(jpql,Long.class);
		query.setParameter("city", "Mumbai");
		System.out.println(query.getSingleResult());*/
		
		/*String jpql = "select p.personName from Person p where p.personCity=:city";
		TypedQuery<String> query = em.createQuery(jpql,String.class);
		query.setParameter("city", "Mumbai");
		List<String> perNames = query.getResultList(); 
		for(String p:perNames){
			System.out.println(p);
		}*/
		
		/*String jpql = "select p.personName,p.personAge from Person p where p.personCity=:city";
		TypedQuery<Object[]> query = em.createQuery(jpql,Object[].class);
		query.setParameter("city", "Mumbai");
		List<Object[]> perDetails =query.getResultList();
		
		for(Object ob[]:perDetails){	
			System.out.println(ob[0]+" "+ob[1]);
		}*/
		
		/*//String jpql = "select p,pt from Person p join Passport pt on p.personCity=:city";
		//String jpql = "select p,pt from Person p left outer join Passport pt";
		TypedQuery<Object[]> query = em.createQuery(jpql,Object[].class);
		query.setParameter("city", "Pune");
		List<Object[]> perPass = query.getResultList();
		for(Object ob[]:perPass){
			Person p = (Person)ob[0];
			
			System.out.println(p.getPersonId()+" "+p.getPersonName()+" "+pt.getNationality());
		}
		*/
		/*String jpql = "select p from Person p left outer join p.passport";
        TypedQuery<Person> query = em.createQuery(jpql,Person.class);
       
   
        List<Person> personPasswortDetails = query.getResultList();
       
        for(Person p:personPasswortDetails){   
            System.out.println( p.getPersonId()+" "+p.getPersonName()+" "
        +p.getPersonAge()+" "
        +(p.getPassport()==null?"Null":p.getPassport().getPassportId())+" "
        +(p.getPassport()==null?"Null":p.getPassport().getNationality()));
        }*/
		
	/*	String jpql = "select p from Person p right outer join p.passport";
        TypedQuery<Person> query = em.createQuery(jpql,Person.class);
       
   
        List<Person> personPasswortDetails = query.getResultList();
       
        for(Person p:personPasswortDetails){   
            System.out.println( p.getPersonId()+" "+p.getPersonName()+" "
        +p.getPersonAge()+" "
        +(p.getPassport()==null?"Null":p.getPassport().getPassportId())+" "
        +(p.getPassport()==null?"Null":p.getPassport().getNationality()));
        }*/
		
	/*	String jpql="select al from Album al join fetch al.songs";
		
		List<Album> albums = em.createQuery(jpql).getResultList();
		
		for(Album al : albums){
			System.out.println(al.getAlbumId()+" "+al.getAlbumName());
				for(Song s:al.getSongs()){
					System.out.println(s.getTitle());
				}
		}
		*/
		//String jpql = "select p from Person p where "
	/*	String jpql = "select p from Person p where p.personAge between 20 and 25"; 	
		TypedQuery<Person> query = em.createQuery(jpql,Person.class);
		List<Person> persons = query.getResultList();
		for(Person p:persons){
			System.out.println(p.getPersonName());
		}*/
		
		
		/*String jpql="select p from Person p where p.personAge=(select max(p.personAge) from Person p)";
		TypedQuery<Person> query = em.createQuery(jpql,Person.class);
		Person person = query.getSingleResult();
		System.out.println(person.getPersonName());*/
		
	/*	String jpql="select p from Person p where p.personAge=(select min(p.personAge) from Person p)";
		TypedQuery<Person> query = em.createQuery(jpql,Person.class);
		Person person = query.getSingleResult();
		System.out.println(person.getPersonName());*/
		
		/*String jpql="select p from Person p Order by p.personAge DESC";
		TypedQuery<Person> query = em.createQuery(jpql,Person.class);
		List<Person> persons = query.getResultList();
		for(Person p:persons){
			System.out.println(p.getPersonName());
		}*/
		
	}

}
