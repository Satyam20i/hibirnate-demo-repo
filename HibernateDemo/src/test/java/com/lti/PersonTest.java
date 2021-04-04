package com.lti;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Persistence;

import org.junit.Test;

import com.lti.dao.PersonDao;
import com.lti.model.Aadhar;
import com.lti.model.Calc;
import com.lti.model.Person;

public class PersonTest {
	
	PersonDao dao = new PersonDao();
//	@Test
//	public void test() {
//		//fail("Not yet implemented");
//		Calc calc= new Calc();
//		//assertTrue(calc.isGreater(50, 20));
//		
//		assertEquals(0,calc.product(5, 0));
//		
//		String str1="Jhon";
//		String str2="Jhon1";
//		//assertSame(str1,str2);
//		assertNotSame(str1,str2);
//		
//	}
//	@Test
//	public void addAadharrWithPerson(){
//		PersonDao dao = new PersonDao();
//		
//		Aadhar aadhar = new Aadhar();	
//		aadhar.setAddress("HYD");
//		aadhar.setDateOfBirth(LocalDate.of(1997, 12, 14));
//		Person person = dao.findAPersonById(6);
//		dao.addAadharrWithPerson(aadhar);
//	}
//	
//	@Test
//	public void viewAllAadhars(){
//		List<Aadhar> aadharlist= dao.viewAllAadhars();
//		for(Aadhar aadhar:aadharlist){
//			System.out.println(aadhar.getAadharNo()+" "+aadhar.getAddress()+" "+aadhar.getDateOfBirth());
//		}
//	}
	@Test
	public void findPersonByAadharNo(){
		Person person=dao.findPersonByAadharNo(26);
		assertNotNull("person not found", person);
	}


}
