package com.wipro.timetracker.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.wipro.timetracker.dao.ProjectDao;
import com.wipro.timetracker.model.Project;
import com.wipro.timetracker.util.DBUtil;

public class ProjectDaoImpl implements ProjectDao{
	
	private Connection dbConnection;
	private PreparedStatement pStmt;
	final static Logger logger = Logger.getLogger(ProjectDaoImpl.class);
	
	public ProjectDaoImpl(){
		dbConnection = DBUtil.getCon();
	}

	public List<Project> getAllProjects(){
		
		List<Project> projectList = new ArrayList<Project>();
		Project project;
        String query = "SELECT * FROM PROJECT ORDER BY PROJECT_ID";
        try {
                Statement stmt = dbConnection.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                        project = new Project();
                        
                        project.setProjectId(rs.getInt("PROJECT_ID"));
                        project.setProjectName(rs.getString("PROJECT_NAME"));
                        project.setProjectActive(rs.getString("PROJECT_ACTIVE"));
                        project.setProjectDescription(rs.getString("PROJECT_DESCRIPTION"));
                        project.setProjectStartDate(rs.getString("PROJECT_STARTDATE"));
                        project.setProjectEndDate(rs.getString("PROJECT_ENDDATE"));
                        project.setProjectManagerUserId(rs.getInt("PROJECT_MANAGER_USER_ID"));
                        
                        projectList.add(project);
                }
        } catch (SQLException e) {
        	logger.error(e.getMessage());
        }
		return projectList;
	}

	@Override
	public void addProject(Project project) {
		String insertQuery = "INSERT INTO PROJECT(PROJECT_ID, PROJECT_NAME, PROJECT_DESCRIPTION, PROJECT_ACTIVE, " +
				"PROJECT_STARTDATE, PROJECT_ENDDATE, PROJECT_MANAGER_USER_ID) VALUES (?,?,?,?,?,?,?)";
		try {
			pStmt = dbConnection.prepareStatement(insertQuery);
			pStmt.setInt(1, project.getProjectId());
			pStmt.setString(2, project.getProjectName());
			pStmt.setString(3, project.getProjectDescription());
			pStmt.setString(4, project.getProjectActive());
			pStmt.setString(5, project.getProjectStartDate());
			pStmt.setString(6, project.getProjectEndDate());
			pStmt.setInt(7, project.getProjectManagerUserId());
			pStmt.executeUpdate();
			if(pStmt.executeUpdate()!=0){
				logger.info("Record inserted successfully for project with Id : " + project.getProjectId());
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public void updateProject(Project project) {

		String updateQuery = "UPDATE PROJECT SET PROJECT_NAME = ?, "
				+ "PROJECT_DESCRIPTION = ?, PROJECT_ACTIVE = ?, PROJECT_STARTDATE = ?, PROJECT_ENDDATE = ?, PROJECT_MANAGER_USER_ID = ?  WHERE PROJECT_ID = ?";
		try {
			pStmt = dbConnection.prepareStatement(updateQuery);
			
			pStmt.setString(1, project.getProjectName());
			pStmt.setString(2, project.getProjectDescription());
			pStmt.setString(3, project.getProjectActive());
			pStmt.setString(4, project.getProjectStartDate());
			pStmt.setString(5, project.getProjectEndDate());
			pStmt.setInt(6, project.getProjectManagerUserId());
			pStmt.setInt(7, project.getProjectId());
			
			if(pStmt.executeUpdate()!=0){
				logger.info("Record updated successfully for project with Id : " + project.getProjectId());
			}else{
				logger.error("There is some problem while updating record");
			}

		} catch (SQLException e) {
			logger.error(e.getMessage());
		}

	}

	@Override
	public void deleteProject(int projectId) {
		
		String deleteQuery = "DELETE FROM PROJECT WHERE PROJECT_ID = ?";
        try {
                pStmt = dbConnection.prepareStatement(deleteQuery);
                pStmt.setInt(1, projectId);
                if(pStmt.executeUpdate()!=0){
                	logger.info("Record deleted successfully for project with Id : " + projectId);
                }else{
                	logger.error("There is some problem while deleting record");
                }
        } catch (SQLException e) {
                System.err.println(e.getMessage());
        }

	}

}
