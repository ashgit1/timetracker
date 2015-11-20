package com.wipro.timetracker.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="ROLE") 
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id 
	@Column(name="ROLE_ID", nullable = false)
	private int roleId;

	@Column(name="ROLE_NAME", nullable = false)
	private String roleName;
	
	@Column(name="DESCRIPTION", nullable = false)
	private String decription;

	@Column(name="ROLE_ID")
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Column(name="ROLE_NAME")
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name="DESCRIPTION")
	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}
	
	

}
