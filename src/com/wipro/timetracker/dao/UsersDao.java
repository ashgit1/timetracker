package com.wipro.timetracker.dao;

import java.util.List;
import java.util.Map;

import com.wipro.timetracker.model.Users;

public interface UsersDao {

	List<String> getProjectName();
	List<String> getRoleName();
	int getProjectIdByName(String projectName);
	int getRoleIdByName(String roleName);
	List<Users> getAllUsers();
	
	Map<Integer, String> projectNames();
	Map<Integer, String> getUserDisplayNameBasedOnProject(String ParentValue);
	
}
