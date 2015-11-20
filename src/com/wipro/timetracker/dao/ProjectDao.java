package com.wipro.timetracker.dao;

import java.util.List;

import com.wipro.timetracker.model.Project;

public interface ProjectDao {
	
	public List<Project> getAllProjects();
	public void addProject(Project project);
	public void updateProject(Project project);
	public void deleteProject(int projectId);

}
