package com.wipro.timetracker.daoimpl;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import com.wipro.timetracker.dao.UsersDao;
import com.wipro.timetracker.model.Users;
import com.wipro.timetracker.util.DBUtil;

public class UsersDaoImpl implements UsersDao{
	
	final static Logger logger = Logger.getLogger(UsersDaoImpl.class);
	private Connection dbConnection;
	private PreparedStatement pStmt;
	private Statement stmt;
	private ResultSet rs;
	private Users user;
	List<Users> userList;
	List<String> projectNames;
	List<String> roleNames;
	int projectId,roleId;
	Map<Integer, String> projectsMap;

	public UsersDaoImpl(){
		dbConnection = DBUtil.getCon();
	}
	
	@Override
	public List<String> getProjectName() {
		projectNames = new ArrayList<String>();
		String projectName;
		String getProjectsQuery = "select distinct(project_name) from project";
        try {
                stmt = dbConnection.createStatement();
                rs = stmt.executeQuery(getProjectsQuery);
                while (rs.next()) {
                	    projectName = new String(rs.getString("project_name"));
                	    projectNames.add(projectName);
                }
        } catch (SQLException e) {
        	logger.error(e.getMessage());
        }
		return projectNames;
	}

	@Override
	public List<String> getRoleName() {
		roleNames = new ArrayList<String>();
		
		String roleName;
		String getRolesQuery = "select distinct(role_name) from role";
        try {
                stmt = dbConnection.createStatement();
                rs = stmt.executeQuery(getRolesQuery);
                while (rs.next()) {
                	roleName = new String(rs.getString("role_name"));
                	roleNames.add(roleName);
                }
        } catch (SQLException e) {
        	logger.error(e.getMessage());
        }
		
		return roleNames;
	}

	@Override
	public int getProjectIdByName(String projectName) {
		
		String queryGetProjectId="select project_id from project where project_name = ?";
		try{
			pStmt = dbConnection.prepareStatement(queryGetProjectId);
			pStmt.setString(1, projectName);
			rs = pStmt.executeQuery();
			while(rs.next()){
				projectId = rs.getInt("project_id");
			}
		}catch(SQLException e){
			logger.error(e.getMessage());
		}
		return projectId;
	}

	@Override
	public int getRoleIdByName(String roleName) {
		
		String queryGetRoleId=" select role_id from role where role_name = ?";
		try{
			pStmt = dbConnection.prepareStatement(queryGetRoleId);
			pStmt.setString(1, roleName);
			rs = pStmt.executeQuery();
			while(rs.next()){
				roleId = rs.getInt("role_id");
			}
		}catch(SQLException e){
			logger.error(e.getMessage());
		}
		return roleId;
	}

	public List<Users> getAllUsers() {
		
		userList = new ArrayList<Users>();
        String getRolesQuery = "SELECT * FROM USERS ORDER BY USER_ID";
        try {
                stmt = dbConnection.createStatement();
                rs = stmt.executeQuery(getRolesQuery);
                while (rs.next()) {
                        user = new Users();
                        user.setUserId(rs.getInt("user_id"));
                        user.setUserName(rs.getString("user_name"));
                        user.setDisplayName(rs.getString("display_name"));
                        user.setPassword(rs.getString("password"));
                        user.setProjectID(rs.getInt("project_id"));
                        user.setRoleId(rs.getInt("role_id"));
                        userList.add(user);
                }
        } catch (SQLException e) {
        	logger.error(e.getMessage());
        }
		return userList;
	}

	@Override
	public Map<Integer, String> projectNames() {
		
		projectsMap = new HashMap<Integer, String>();
		String getProjectsQuery = "select distinct(project_name), project_id from project";
        try {
                stmt = dbConnection.createStatement();
                rs = stmt.executeQuery(getProjectsQuery);
                while (rs.next()) {
                		projectsMap.put(rs.getInt("project_id"), rs.getString("project_name"));
                }
        } catch (SQLException e) {
        	logger.error(e.getMessage());
        }
        
		return projectsMap;
	}

}
