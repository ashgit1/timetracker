package com.wipro.timetracker.test;

import java.util.List;

import com.wipro.timetracker.daoimpl.UsersDaoImpl;

public class UsersDaoImplTest {

	public static void main(String[] args) {

		UsersDaoImpl userDaoTest = new UsersDaoImpl();
		
		/**
		 * Testing the distinct projectNames from PROJECT table...
		 */
		List<String> projectList = userDaoTest.getProjectName();
		System.out.println("Project List:\n-------------");
		for(String project : projectList){
			System.out.println(project);
		}
		
		System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++\n");
		
		/**
		 * Testing the distinct roleNames from ROLE table...
		 */
		List<String> roleList = userDaoTest.getRoleName();
		System.out.println("Role List:\n-------------");
		for(String role : roleList){
			System.out.println(role);
		}
		
		/**
		 * Get the project_id based on project name
		 */
		String projectName="TSD-Middleware";
		System.out.println("Project Name: " + projectName + ", Project ID = " + userDaoTest.getProjectIdByName(projectName));
		
		/**
		 * Get the role_id based on role name
		 */
		String roleName="Release Engineer";
		System.out.println("Role Name: " + roleName + ", Role Id = " + userDaoTest.getRoleIdByName(roleName));
	
		//userDaoTest.getDisplayName();
		
	}

}
