package com.lti.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tbl_department")
public class Department {
	@Id
	@SequenceGenerator(name="dep_seq",initialValue=6001,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="dep_seq")
	int deptId;
	@Column
	String deptName;
	@Column
	String locaion;
	@OneToMany(mappedBy="department")
	List<Employee> employees;
	@OneToMany(mappedBy="department")
	List<Project> projects;
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLocaion() {
		return locaion;
	}
	public void setLocaion(String locaion) {
		this.locaion = locaion;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	
	
}
