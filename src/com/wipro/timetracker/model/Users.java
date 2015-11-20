package com.wipro.timetracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne
	@JoinColumn(name = "PROJECT_ID")
	private Project projectId;
	
	@ManyToOne
	@JoinColumn(name = "ROLE_ID")
	private Role roleId;

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

	@Column(name = "PROJECT_ID")
	public Project getProjectId() {
		return projectId;
	}

	public void setProjectId(Project projectId) {
		this.projectId = projectId;
	}

	@Column(name = "ROLE_ID")
	public Role getRoleId() {
		return roleId;
	}

	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}
	
}
