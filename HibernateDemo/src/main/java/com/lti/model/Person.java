package com.lti.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_person")//Optional
public class Person {
	@Id //Specifies Primary Ke
	
	@GeneratedValue
	@Column(name="person_id") //Optional
	int personId;
	@Column(name="person_name") //Optional
	String personName;
	@Column(name="person_age") //Optional
	int personAge;
	@Column(name="person_city") //Optional
	String personCity;
	@OneToOne(mappedBy= "person",cascade=CascadeType.ALL,fetch=FetchType.LAZY) //do not create FK here,
								//it is created in Passport table using personId
	Passport passport;
	@OneToOne(mappedBy= "person",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	Aadhar aadhar;
	public Aadhar getAadhar() {
		return aadhar;
	}
	public void setAadhar(Aadhar aadhar) {
		this.aadhar = aadhar;
	}
	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public int getPersonAge() {
		return personAge;
	}
	public void setPersonAge(int personAge) {
		this.personAge = personAge;
	}
	public String getPersonCity() {
		return personCity;
	}
	public void setPersonCity(String personCity) {
		this.personCity = personCity;
	}
	
}
