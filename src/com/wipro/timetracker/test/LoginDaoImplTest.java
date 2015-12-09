package com.wipro.timetracker.test;

import com.wipro.timetracker.daoimpl.LoginDaoImpl;

public class LoginDaoImplTest {

	
	public static void main(String[] args) {

		LoginDaoImpl loginDaoTest = new LoginDaoImpl();
		
		/**
		 * Testing the distinct projectNames from PROJECT table...
		 */
		boolean isvalid =  loginDaoTest.validateUser("ashishkg", "Ashish@123");
		if(isvalid){
			System.out.println("user exist");
		}else{
			System.out.println("user doesn't exist");
		}
		System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++\n");
		
	}

}
