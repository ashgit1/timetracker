/**
 * 
 */
package com.wipro.timetracker.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author agupt40
 *
 */

@Entity
@Table (name="PROJECT") 
public class Project implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@Column(name="PROJECT_ID", nullable = false)
	private int projectId;

	@Column(name="PROJECT_NAME", nullable = false)
	private String projectName;

	@Column(name="PROJECT_MANAGER_USER_ID", nullable = false)
	private	int projectManagerUserId;

	@Column(name="PROJECT_DESCRIPTION", nullable = false)
	private String projectDescription;

	@Column(name="PROJECT_ACTIVE", nullable = false)
	private String projectActive;
	
	@Column(name="PROJECT_STARTDATE", nullable = false)
	private String projectStartDate;
	
	@Column(name="PROJECT_ENDDATE", nullable = false)
	private String projectEndDate;

	@Column(name="PROJECT_ID")
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	@Column(name="PROJECT_NAME")
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Column(name="PROJECT_MANAGER_USER_ID")
	public int getProjectManagerUserId() {
		return projectManagerUserId;
	}

	public void setProjectManagerUserId(int projectManagerUserId) {
		this.projectManagerUserId = projectManagerUserId;
	}

	@Column(name="PROJECT_DESCRIPTION")
	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	@Column(name="PROJECT_ACTIVE")
	public String getProjectActive() {
		return projectActive;
	}

	public void setProjectActive(String projectActive) {
		this.projectActive = projectActive;
	}

	@Column(name="PROJECT_STARTDATE")
	public String getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(String projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	@Column(name="PROJECT_ENDDATE")
	public String getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(String projectEndDate) {
		this.projectEndDate = projectEndDate;
	}
	
}