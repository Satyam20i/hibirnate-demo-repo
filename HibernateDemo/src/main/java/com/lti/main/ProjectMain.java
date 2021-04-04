package com.lti.main;

import java.util.List;

import com.lti.dao.ProjectDao;
import com.lti.model.Person;
import com.lti.model.Project;

public class ProjectMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Project project = new Project();
		ProjectDao dao = new ProjectDao();
		/*project.setProjectId(1);
		project.setProjectName("Gladiator");
		project.setDuration(12);
		dao.addOrupdateProject(project);
		*/
	/*	List<Project> projects = dao.findProjectByName("QMS");
		for(Project project:projects){
		System.out.println(project.getProjectId()+" "+project.getProjectName()+" "+project.getDuration());
		}*/
		/*List<Project> projects = dao.viwaAllProjects();
		for(Project project:projects){
			System.out.println(project.getProjectId()+" "+project.getProjectName()+" "+project.getDuration());
		}
		*/

	}

}
