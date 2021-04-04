package com.lti.model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.lti.dao.EmployeeDao;

public class EmployeeTest {
	EmployeeDao dao = new EmployeeDao();

	@Test
	public void addaEmployee(){ //DonE
		Employee employee = new Employee();
		employee.setEmpName("Divvy");
		employee.setDesignation("Graduate Traninee");
		Department dept = dao.findDepartmentById(6002);
		if(dept==null){
			System.out.println("Oops No Such Department");
		}
		else{
			employee.setDepartment(dao.findDepartmentById(6002));
			Project prj = dao.findProjectById(7104);
			if(prj==null){
				System.out.println("No Projects for Given Id");
			}else{
				employee.setProject(dao.findProjectById(7104));
				Employee emp= dao.addOrUpadateAnEmployee(employee);
				System.out.println(emp.getEmpId()+" "+emp.getEmpName()+" "+emp.getDesignation()+" "+emp.getDepartment().getDeptName()+" "+emp.getProject().getProjName());
			}
		}
	}
	@Test
	public void addDepartment(){  //DonE
		Department department = new Department();
		department.setDeptName("Testing");
		department.setLocaion("Mumbai");
		Department dept = dao.addOrUpdateDepartment(department);
		System.out.println(dept.getDeptId()+" "+dept.getDeptName()+" "+dept.getLocaion());
	}
	@Test
	public void addProject(){    //DonE
		Project project = new Project();
		project.setProjName("TestEbancking");         
		project.setDuration(29.5);                      
		Department dept = dao.findDepartmentById(6002);
		if(dept==null){
			System.out.println("No Such Department");
		}
		else{
			project.setDepartment(dao.findDepartmentById(6002));
			Project prj = dao.addOrUpdateProject(project);
			System.out.println(prj.getPrjId()+" "+prj.getProjName()+" "+prj.getDuration()+" "+prj.getDepartment().getDeptName());
		}
		
	}
	@Test 
	public void findEmployeeById(){   //DonE
		Employee emp = dao.findEmployeeById(5101);
		if(emp==null){
			System.out.println("No Such Employee");
		}
		else{
			System.out.println(emp.getEmpId()+" "+emp.getEmpName()+" "+emp.getDesignation()+" "+emp.getDepartment().getDeptName()+" "+emp.getProject().getProjName());
		}
	}
	@Test
	public void viewAllEmpoyees(){  //DonE
		List<Employee> emps= dao.viewAllEmployees();
		if(emps.size()<1){
			System.out.println("No Employees Are There");
		}
		else{
			for(Employee emp:emps){
				System.out.println(emp.getEmpId()+" "+emp.getEmpName()+" "+emp.getDesignation()+" "+emp.getDepartment().getDeptName()+" "+emp.getProject().getProjName());
			}
		}
	}
	@Test
	public void findDepartmentById(){  //DonE
		Department dept = dao.findDepartmentById(6001);
		if(dept==null){
			System.out.println("No Such Department");
		}
		else{
			System.out.println(dept.getDeptId()+" "+dept.getDeptName()+" "+dept.getLocaion());
		}
	}
	@Test
	public void viewAllProjectsByDepartmentId(){  //DonE
		List<Project> prjs = dao.viewAllProjectByDepartmentId(6001);
		if(prjs.size()<1){
			System.out.println("No Projects Now");
		}else{
			for(Project prj:prjs){
				System.out.println(prj.getPrjId()+" "+prj.getProjName()+" "+prj.getDuration()+" "+prj.getDepartment().getDeptName());
			}
		}
	}
	@Test
	public void viewAllEmployeesByProjectId(){ //DonE
		List<Employee> emps= dao.viewAllEmployeesByProjectId(7101);
		if(emps.size()<1){
			System.out.println("No Employees Are There");
		}
		else{
			for(Employee emp:emps){
				System.out.println(emp.getEmpId()+" "+emp.getEmpName()+" "+emp.getDesignation()+" "+emp.getDepartment().getDeptName()+" "+emp.getProject().getProjName());
			}
		}
	}
	@Test 
	public void viewAllEmployeesByDepartmentsId(){  //OkE TestEd
		List<Employee> emps= dao.viewAllEmployeesByDeapartmentId(6001);
		if(emps.size()<1){
			System.out.println("No Employees Are There");
		}
		else{
			for(Employee emp:emps){
				System.out.println(emp.getEmpId()+" "+emp.getEmpName()+" "+emp.getDesignation()+" "+emp.getDepartment().getDeptName()+" "+emp.getProject().getProjName());
			}
		}
	}
	@Test
	public void viewAllEmployeesByDepartmentNameAndProjectName(){ //DonE
		List<Employee> emps= dao.viewAllEmployeesByDepartmentNameAndProjectName("Testing","TestEbancking");
		if(emps.size()<1){
			System.out.println("No Employees Are There");
		}
		else{
			for(Employee emp:emps){
				System.out.println(emp.getEmpId()+" "+emp.getDesignation()+" "+emp.getDepartment().getDeptName()+" "+emp.getProject().getProjName());
			}
		}
	}
	

}
