package com.lti.main;

import java.time.LocalDate;
import java.util.List;

import com.lti.dao.PersonDao;
import com.lti.model.Aadhar;
import com.lti.model.Passport;
import com.lti.model.Person;

public class PersonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonDao dao = new PersonDao();
		
//		Person person = new Person();
		//person.setPersonId(10000);
		/*person.setPersonName("Breach");
		person.setPersonAge(23);
		person.setPersonCity("Russia");
		
		dao.addOrupdatePerson(person);*/
/*		Person person = dao.findAPersonById(77);
		if(person!=null){
			System.out.println(person.getPersonId()+" "+person.getPersonName()+" "+person.getPersonAge()+" "+person.getPersonCity());
		}
		else{
			System.out.println("Person Doesn't Exits");
		}*/
		
		/*List<Person> persons = dao.viwaAllPersons();
		for(Person person:persons){
			System.out.println(person.getPersonId()+" "+person.getPersonName()+" "+person.getPersonAge()+" "+person.getPersonCity());
		}
		*/
	/*	List<Person> persons = dao.findPersonByName("Divyy");
		for(Person person:persons){
			System.out.println(person.getPersonId()+" "+person.getPersonName()+" "+person.getPersonAge()+" "+person.getPersonCity());
		}*/
//		
//		Person person = new Person();
//		person.setPersonName("Sharad");
//		person.setPersonAge(16);
//		person.setPersonCity("Pune");
		
//		Passport passport = new Passport();
//		passport.setNationality("India");
//		passport.setPlaceOfBirth("Pune");
//		passport.setValidFrom(LocalDate.of(2010, 12, 20));
//		passport.setValidTill(LocalDate.of(2020, 12, 19));
//		Person person;
//		person=dao.findAPersonById(1);
//		passport.setPerson(person);
//		
//		dao.addPassportWithPerson(passport);
		
//		person.setPassport(passport);
//		passport.setPerson(person);
//		
//		dao.addPersonWithPassport(person);
		
//		
//		Aadhar aadhar = new Aadhar();
//		aadhar.setAddress("B-304,Amisha");
//		aadhar.setDateOfBirth(LocalDate.of(2002, 7, 11));
//		
//		Person person = new Person();
//		person.setPersonName("Shubham");
//		person.setPersonAge(17);
//		person.setPersonCity("Mumbai");
//		person.setAadhar(aadhar);
//		aadhar.setPerson(person);
//		
//		dao.addPersonWithAadhar(person);
//		
//		Aadhar aadhar = new Aadhar();
//		aadhar.setAddress("B-905,Galaxy");
//		aadhar.setDateOfBirth(LocalDate.of(2002, 10, 5));
//		
//		Person person = dao.findAPersonById(4);
//		if(dao.hasAadharAllocated(person.getPersonId())){
//			System.out.println("Person already has the Addhar");
//		}
//		else{
//			person.setAadhar(aadhar);
//			aadhar.setPerson(person);
//			dao.addAadharrWithPerson(aadhar);
//		}
//			
//		List<Aadhar> aadhars = dao.viewAllAadhars();
//		for(Aadhar aadhar:aadhars){
//			System.out.println(aadhar.getAadharNo()+" "+aadhar.getAddress()+" "+aadhar.getDateOfBirth());
//		}
		 
//		Aadhar aadhar =dao.findAadharByNo(26);
//		System.out.println(aadhar.getAadharNo()+" "+aadhar.getAddress()+" "+aadhar.getDateOfBirth()+" "+aadhar.getPerson().getPersonId());
//		Person person= dao.findPersonByAadharNo(26);
//		System.out.println(person.getPersonId()+" "+person.getPersonName()+" "+person.getPersonAge()+" "+person.getPersonCity());
		
//		if(dao.hasAadharAllocated(6)){
//			System.out.println("Hai mere pass");
//		}
//		else{
//			System.out.println("Nahi Hai Bhai ");
//		}
		
	}
}
