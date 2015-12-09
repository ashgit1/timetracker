package com.wipro.timetracker.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="COMPOFF") 
public class CompOff implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id 
	@Column(name="COMPOFF_ID", nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int compOffId;
	
	@Column(name="USER_ID", nullable = false)
	private int userId;
	
	@Column(name="ACTION_DATE")
	private String actionDate;
	
	@Column(name="TYPE")
	private String type;
	
	@Column(name="TYPE_DETAIL")
	private String typeDetail;
	
	@Column(name="TASK_TYPE")
	private String taskType;
	
	@Column(name="TIME_TAKEN")
	private int timeTaken;
	
	@Column(name="TASK_DESCRIPTION")
	private String taskDesc;
	
	@Column(name="COMP_OFF_UTILIZED")
	private int compOffUtilized;
	
	public int getCompOffId() {
		return compOffId;
	}
	public void setCompOffId(int compOffId) {
		this.compOffId = compOffId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getActionDate() {
		return actionDate;
	}
	public void setActionDate(String actionDate) {
		this.actionDate = actionDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTypeDetail() {
		return typeDetail;
	}
	public void setTypeDetail(String typeDetail) {
		this.typeDetail = typeDetail;
	}
	public String getTaskType() {
		return taskType;
	}
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	public int getTimeTaken() {
		return timeTaken;
	}
	public void setTimeTaken(int timeTaken) {
		this.timeTaken = timeTaken;
	}
	public String getTaskDesc() {
		return taskDesc;
	}
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}
	public int getCompOffUtilized() {
		return compOffUtilized;
	}
	public void setCompOffUtilized(int compOffUtilized) {
		this.compOffUtilized = compOffUtilized;
	}

}
