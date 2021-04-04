package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.lti.model.Department;
import com.lti.model.Employee;
import com.lti.model.Project;

public class EmployeeDao {
	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;
	public EmployeeDao(){
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}
	public Employee addOrUpadateAnEmployee(Employee employee){ //OkE TestEd
		tx.begin();
		Employee emp = em.merge(employee);
		tx.commit();
		return emp;
	}
	public List<Employee> viewAllEmployees(){          //OkE TestEd
		String jpql ="Select e from Employee e";
		TypedQuery<Employee> query = em.createQuery(jpql,Employee.class);
		return query.getResultList();
	}
	public Employee findEmployeeById(int empId){ //OkE TestEd
		return em.find(Employee.class, empId);
	}
	public Department addOrUpdateDepartment(Department department){ //OkE TestEd
		tx.begin();
		Department dept = em.merge(department);
		tx.commit();
		return dept;
	}
	public Department findDepartmentById(int deptId){ //OkE TestEd
		return  em.find(Department.class, deptId);
	}
	public Project addOrUpdateProject(Project project){ //OkE TestEd
		tx.begin();
		Project prj = em.merge(project);
		tx.commit();
		return prj;
	}
	public Project findProjectById(int prjId){ //OkE TestEd
		return em.find(Project.class, prjId);
	}
	
	public List<Project> viewAllProjectByDepartmentId(int deptId){  //OkE TestEd
		String jpql = "Select p from Project p where p.department.deptId=:depId";
		TypedQuery<Project> query= em.createQuery(jpql,Project.class);
		query.setParameter("depId", deptId);
		return query.getResultList();
		
	}
	public List<Project> viewAllProjectByDepartmentId1(int deptId){
		Department dept = findDepartmentById(deptId);
		return dept.getProjects();
		
	}
	public List<Employee> viewAllEmployeesByProjectId(int prjId){  //OkE TestEd
		String jpql =" select e from Employee e where e.project.prjId=:pId";
		TypedQuery<Employee> query = em.createQuery(jpql,Employee.class);
		query.setParameter("pId", prjId);
		return query.getResultList();
	}
	public List<Employee> viewAllEmployeesByProjectId1(int prjId){
		Project prj = findProjectById(prjId);
		return prj.getEmployees();
	}

	public List<Employee> viewAllEmployeesByDeapartmentId(int deptId){ //OkE TestEd
		String jpql ="select e from Employee e where e.department.deptId=:depId";
		TypedQuery<Employee> query = em.createQuery(jpql,Employee.class);
		query.setParameter("depId", deptId);
		return query.getResultList();
	}
	public List<Employee> viewAllEmployeesByDeapartmentId1(int deptId){
		Department dept = findDepartmentById(deptId);
		return dept.getEmployees();
	}
	public List<Employee> viewAllEmployeesByDepartmentNameAndProjectName(String deptName,String prjName){  //OkE TestEd
		String jpql = "select e from Employee e where e.department.deptName=:depName and e.project.projName=:pName";
		TypedQuery<Employee> query = em.createQuery(jpql,Employee.class);
		query.setParameter("depName", deptName);
		query.setParameter("pName", prjName);
		return query.getResultList();
	}
	
}
