package com.wipro.timetracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="USERS") 
public class Users {

	@Id 
	@Column(name="USER_ID", nullable = false)
	private int userId;

	@Column(name="USER_NAME", nullable = false)
	private String userName;
	
	@Column(name="PASSWORD", nullable = false)
	private String password;
	
	@Column(name="DISPLAY_NAME", nullable = false)
	private String displayName;
	
	@Column(name="PROJECT_ID", nullable = false)
	private int projectID;
	
	@Column(name="ROLE_ID", nullable = false)
	private int roleId;
	

	@Column(name="USER_ID")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name="USER_NAME")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name="PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="DISPLAY_NAME")
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Column(name="PROJECT_ID")
	public int getProjectID() {
		return projectID;
	}

	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

	@Column(name="ROLE_ID")
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
}
