package com.lti.model;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import com.lti.dao.CourseDao;

public class CourseTest {
	CourseDao dao = new CourseDao();
	@Test
	public void regiOrUpdateUser(){
		User user = new User();
		user.setUserName("Swapnil");
		user.setUserPass("s_WAP#69");
		user.setEmail("s.Nile@lti.com");
		user.setCity("Mumbai");
		user.setUserPhone("8879543221");
		
		User u1 = dao.registerOrUpdateUser(user);
		System.out.println(u1.getUserId()+" "+u1.getUserName()+" "+u1.getEmail()+" "+u1.getUserPass()+" "+u1.getCity()+" "+u1.getUserPhone());
	}
	@Test
	public void logUser(){
		String msg =dao.loginUser(1063,"s_Loading#31");
		System.out.println(msg);
	}
	@Test
	public void findUser(){
		User u1 =dao.findUserById(1077);
		if(u1==null){
			System.out.println("No Such User");
		}else{
			System.out.println(u1.getUserId()+" "+u1.getUserName()+" "+u1.getEmail()+" "+u1.getUserPass()+" "+u1.getCity()+" "+u1.getUserPhone());

		}
	}
	@Test
	public void addCourse(){
		Course course = new Course();
		course.setCourseName("Angular");
		course.setDuration(17.8);
		course.setFees(12500);	
		Course cur =dao.addNewOrUpdateCourse(course);
		System.out.println(cur.getCourseId()+" "+cur.getCourseName()+" "+cur.getDuration()+" "+cur.getFees());
	}
	@Test
	public void findCourseById(){
		Course cur =dao.findCourseById(2021);
		System.out.println(cur.getCourseId()+" "+cur.getCourseName()+" "+cur.getDuration()+" "+cur.getFees());
	}
	@Test
	public void viewAllCourses(){
		List<Course> courses= dao.viewAllCourse();
		for(Course cur:courses){
			System.out.println(cur.getCourseId()+" "+cur.getCourseName()+" "+cur.getDuration()+" "+cur.getFees());
		}
	}
	@Test
	public void addEnrollments(){
		Enrollment enrollment = new Enrollment();
		enrollment.setEnrDate(LocalDate.of(2020, 3, 14));
		enrollment.setUser(dao.findUserById(1065));
		enrollment.setCourse(dao.findCourseById(2022));
		Enrollment enr=dao.addEndrollments(enrollment);
		System.out.println(enr.getEnrId()+" "+enr.getCourse().getCourseName()+" "+enr.getEnrDate()+" "+enr.getUser().getUserName());
	}
	@Test
	public void viewAllEnrollments(){
		List<Enrollment> enrs=dao.viewAllEnrollment();
		if(enrs.isEmpty()){
			System.out.println("No Enrollments YET");
		}
		for(Enrollment enr:enrs){
			System.out.println(enr.getEnrId()+" "+enr.getCourse().getCourseName()+" "+enr.getEnrDate()+" "+enr.getUser().getUserName());
		}
	}
	@Test
	public void findEnrollmentById(){
		Enrollment enr=dao.findEnrollmentById(4101);
		if(enr==null){
			System.out.println("No Such Enrollments");	
		}else{
			System.out.println(enr.getEnrId()+" "+enr.getCourse().getCourseName()+" "+enr.getEnrDate()+" "+enr.getUser().getUserName());
		}
		
	}
	@Test
	public void findEnrollmentByDate(){
		LocalDate date= LocalDate.of(2019, 11, 8);
		Enrollment enr=dao.findEnrollmentByDate(date);
		if(enr==null){
			System.out.println("No Such Enrollments for this Date");	
		}else{
			System.out.println(enr.getEnrId()+" "+enr.getCourse().getCourseName()+" "+enr.getEnrDate()+" "+enr.getUser().getUserName());
		}
	}
	@Test
	public void totalNumberOfEnrInCourse(){
		int no = dao.getNumberOfEnrollmentByCourseId(2022);
		System.out.println("Total Enrollments for this Course"+no);
	}
	@Test
	public void findUserbyEnrollId(){
		User u1= dao.findUserByEnrollmentNo(4101);
		System.out.println(u1.getUserId()+" "+u1.getUserName()+" "+u1.getEmail()+" "+u1.getUserPass()+" "+u1.getCity()+" "+u1.getUserPhone());
	}
	
	@Test
	public void findsUsersbycourseId(){
		List<User> users= dao.viewAllUserByCourseId(2022);
		for(User u:users){
			System.out.println(u.getUserId()+" "+u.getUserName()+" "+u.getEmail()+" "+u.getUserPass()+" "+u.getCity()+" "+u.getUserPhone());
		}
	}
	@Test
	public void updateUserProfile(){
		User u1 = dao.findUserById(1063);
		if(u1==null){
			System.out.println("No Such User Exits");
		}
		else{
			u1.setUserPhone("887776655");
			dao.registerOrUpdateUser(u1);
			System.out.println("User Updated");
		}
	}
	
}
