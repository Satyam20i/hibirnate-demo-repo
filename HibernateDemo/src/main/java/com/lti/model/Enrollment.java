package com.lti.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Enrollment {
	@Id
	@SequenceGenerator(name="enr_seq",initialValue=4101,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="enr_seq")
	int enrId;
	@Column
	LocalDate enrDate;
	@ManyToOne
	Course course;
	@OneToOne
	User user;
	public int getEnrId() {
		return enrId;
	}
	public void setEnrId(int enrId) {
		this.enrId = enrId;
	}
	public LocalDate getEnrDate() {
		return enrDate;
	}
	public void setEnrDate(LocalDate enrDate) {
		this.enrDate = enrDate;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
