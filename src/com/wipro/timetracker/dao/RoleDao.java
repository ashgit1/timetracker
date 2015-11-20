package com.wipro.timetracker.dao;

import java.util.List;

import com.wipro.timetracker.model.Role;

public interface RoleDao {

	public List<Role> getAllRoles();
	public void addRole(Role role);
	public void updateRole(Role role);
	public void deleteRole(int roleId);
	
}
