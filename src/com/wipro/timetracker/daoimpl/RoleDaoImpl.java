package com.wipro.timetracker.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.wipro.timetracker.dao.RoleDao;
import com.wipro.timetracker.model.Role;
import com.wipro.timetracker.util.DBUtil;

public class RoleDaoImpl implements RoleDao{

	private Connection dbConnection;
	private PreparedStatement pStmt;
	private Statement stmt;
	private ResultSet rs;
	private Role role;
	List<Role> roleList;
	final static Logger logger = Logger.getLogger(RoleDaoImpl.class);
	
	public RoleDaoImpl(){
		dbConnection = DBUtil.getCon();
	}
	
	@Override
	public List<Role> getAllRoles() {
		
		roleList = new ArrayList<Role>();
        String getRolesQuery = "SELECT * FROM ROLE ORDER BY ROLE_ID";
        try {
                stmt = dbConnection.createStatement();
                rs = stmt.executeQuery(getRolesQuery);
                while (rs.next()) {
                        role = new Role();
                        role.setRoleId(rs.getInt("ROLE_ID"));
                        role.setRoleName(rs.getString("ROLE_NAME"));
                        role.setDecription(rs.getString("DESCRIPTION"));
                        roleList.add(role);
                }
        } catch (SQLException e) {
        	logger.error(e.getMessage());
        }
		return roleList;
	}

	@Override
	public void addRole(Role role) {
		String insertRoleQuery = "INSERT INTO ROLE(ROLE_ID, ROLE_NAME, DESCRIPTION) VALUES (?,?,?)";
		try {
			pStmt = dbConnection.prepareStatement(insertRoleQuery);
			pStmt.setInt(1, role.getRoleId());
			pStmt.setString(2, role.getRoleName());
			pStmt.setString(3, role.getDecription());
			pStmt.executeUpdate();
			if(pStmt.executeUpdate()!=0){
				logger.info("Record inserted successfully for Role with Id : " + role.getRoleId());
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public void updateRole(Role role) {
		
		String updateRoleQuery = "UPDATE ROLE SET ROLE_NAME = ?, DESCRIPTION = ?  WHERE ROLE_ID = ?";
		
		try {
			pStmt = dbConnection.prepareStatement(updateRoleQuery);
			
			pStmt.setString(1, role.getRoleName());
			pStmt.setString(2, role.getDecription());
			pStmt.setInt(3, role.getRoleId());
			
			if(pStmt.executeUpdate()!=0){
				logger.info("Record updated successfully for Role with Id : " + role.getRoleId());
			}else{
				logger.error("There is some problem while updating record for Role");
			}

		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		
	}

	@Override
	public void deleteRole(int roleId) {
		
		String deleteRoleQuery = "DELETE FROM ROLE WHERE ROLE_ID = ?";
        try {
                pStmt = dbConnection.prepareStatement(deleteRoleQuery);
                pStmt.setInt(1, roleId);
                if(pStmt.executeUpdate()!=0){
                	logger.info("Record deleted successfully for Role with Id : " + roleId);
                }else{
                	logger.error("There is some problem while deleting record");
                }
        } catch (SQLException e) {
                System.err.println(e.getMessage());
        }
        
	}

}
