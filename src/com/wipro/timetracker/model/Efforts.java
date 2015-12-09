package com.wipro.timetracker.model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="EFFORTS") 
public class Efforts implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id 
	@Column(name="EFFORTS_ID", nullable = false)
	private int effortsId;
	
	@Column(name="USER_ID", nullable = false)
	private int userId;
	
	@Column(name="START_DATE")
	private String startDate;
	
	@Column(name="END_DATE")
	private String endDate;
	
	@Column(name="LOCATION")
	private String location;
	
	@Column(name="ATTEND_DATA")
	private String attendData;
	
	@Column(name="TEAM")
	private String team;
	
	@Column(name="PROJECT_ID", nullable = false)
	private int projectId;
	
	@Column(name="WEEKLY_HR")
	private int weeklyHr;
	
	@Column(name="EXTRA_HR")
	private int extraHr;
	
	@Column(name="TOTAL_HR")
	private int totalHr;
	
	@Column(name="COMMENTS")
	private String comments;
	
	public int getEffortsId() {
		return effortsId;
	}
	public void setEffortsId(int effortsId) {
		this.effortsId = effortsId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAttendData() {
		return attendData;
	}
	public void setAttendData(String attendData) {
		this.attendData = attendData;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getWeeklyHr() {
		return weeklyHr;
	}
	public void setWeeklyHr(int weeklyHr) {
		this.weeklyHr = weeklyHr;
	}
	public int getExtraHr() {
		return extraHr;
	}
	public void setExtraHr(int extraHr) {
		this.extraHr = extraHr;
	}
	public int getTotalHr() {
		return totalHr;
	}
	public void setTotalHr(int totalHr) {
		this.totalHr = totalHr;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

}
