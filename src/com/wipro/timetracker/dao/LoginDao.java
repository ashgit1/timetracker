package com.wipro.timetracker.dao;

public interface LoginDao {

	boolean validateUser(String username, String password);
	String getDisplayName(String username);
	
}
