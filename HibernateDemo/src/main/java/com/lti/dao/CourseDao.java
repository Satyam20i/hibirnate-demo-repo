package com.lti.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.lti.model.Course;
import com.lti.model.Enrollment;
import com.lti.model.User;

public class CourseDao {
	EntityManager em;
	EntityManagerFactory emf;
	EntityTransaction tx;
	public CourseDao(){
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}
	public User registerOrUpdateUser(User user){//DonE
		tx.begin();
		User userPersist = em.merge(user);
		tx.commit();
		return userPersist;
	}
	public String loginUser(int userId,String userpass){//DonE
		User user = em.find(User.class, userId);
		
		String msg="";
		if(user==null){
			msg=" This User Doesn't Exit";
		}
		if(user.getUserPass().equals(userpass)){
			msg="SuccessFull LogIn";
		}
		else{
			msg="Invalid Credential";
		}
		
		return msg;	
	}
	public User findUserById(int userId){ //DonE
		return em.find(User.class, userId);
	}
	public List<User> viewAllUserByCourseId(int courseId){ //DonE
		String jpql = "select u from User u where u.enrollment.course.courseId=:curId";
		TypedQuery<User> query = em.createQuery(jpql,User.class);
		query.setParameter("curId", courseId);
		return query.getResultList();
	}
	public User findUserByEnrollmentNo(int enrId){ //DonE
		String jpql = "select u from User u where u.enrollment.enrId=:enId";
		TypedQuery<User> query = em.createQuery(jpql,User.class);
		query.setParameter("enId", enrId);
		return query.getSingleResult();
	}
	public Course addNewOrUpdateCourse(Course course){ //DonE
		tx.begin();
		Course coursePersist =em.merge(course);
		tx.commit();
		return coursePersist;
	}
	public List<Course> viewAllCourse(){ //DonE
		String jpql= "select c from Course c";
		TypedQuery<Course> query = em.createQuery(jpql,Course.class);
		return query.getResultList();
	}
	public Course findCourseById(int courseId){ //DonE
		return em.find(Course.class, courseId);
	}
	
	public Course findCourseByUserId(int userId){//DonE
		User user= findUserById(userId);
		Enrollment enr=user.getEnrollment();
		return enr.getCourse();
	}
	public int getNumberOfEnrollmentByCourseId(int courseId){ //DonE
		String jpql = "select e from Enrollment e where e.course.courseId=:curId";
		TypedQuery<Enrollment> query = em.createQuery(jpql,Enrollment.class);
		query.setParameter("curId", courseId);
		return query.getResultList().size();
	}
	public  Enrollment addEndrollments(Enrollment enrollment){ //DonE
		tx.begin();
		Enrollment enrPersist = em.merge(enrollment);
		tx.commit();
		return enrPersist;
	}
	public List<Enrollment> viewAllEnrollment(){ //DonE
		String jpql= "select e from Enrollment e";
		TypedQuery<Enrollment> query = em.createQuery(jpql,Enrollment.class);
		return query.getResultList();
	}
	public Enrollment findEnrollmentById(int enrId){ //DonE
		return em.find(Enrollment.class, enrId);
	}
	public Enrollment findEnrollmentByDate(LocalDate date){ //DonE
		String jpql = "select e from Enrollment e where e.enrDate=:date";
		TypedQuery<Enrollment> query = em.createQuery(jpql,Enrollment.class);
		query.setParameter("date", date);
		return query.getSingleResult();
	}

	
}
