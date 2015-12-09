package com.wipro.timetracker.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wipro.timetracker.daoimpl.RoleDaoImpl;
import com.wipro.timetracker.model.Role;

/**
 * Servlet implementation class RoleController
 */
public class RoleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();
	RoleDaoImpl roleDao = new RoleDaoImpl();
	List<Role> roleList;
    final static Logger logger = Logger.getLogger(ProjectController.class); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		
		if ( action != null){
			
			roleList = new ArrayList<Role>();
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
            response.setContentType("application/json");
            
            if (action.equals("list")){
            	try{ 
            		
            		roleList = roleDao.getAllRoles();
            		
            		//Return in the format required by jTable plugin
                    JSONROOT.put("Result", "OK");
                    JSONROOT.put("Records", roleList);
                    
                    // Convert Java Object to Json
                    String jsonArray = gson.toJson(JSONROOT);
                    System.out.println("Role list: " + jsonArray);

                    response.getWriter().print(jsonArray);
            		
                }catch(Exception ex){
                    JSONROOT.put("Result", "ERROR");
                    JSONROOT.put("Message", ex.getMessage());
                    String error = gson.toJson(JSONROOT);
                    response.getWriter().print(error);
            	} 
            	
            } // list over
            
            if (action.equals("create") || action.equals("update")) {
            	try{
            	        Role role = new Role();
            	        if (request.getParameter("roleId") != null) {
            	                int roleId = Integer.parseInt(request.getParameter("roleId"));
            	                role.setRoleId(roleId);
            	        }

            	        if (request.getParameter("roleName") != null) {
            	                String roleName = request.getParameter("roleName");
            	                role.setRoleName(roleName);
            	        }

            	        if (request.getParameter("decription") != null) {
            	                String roleDescription = request.getParameter("decription");
            	                role.setDecription(roleDescription);
            	        }

            	        if (action.equals("create")) {
            	                // Create new record
            	                roleDao.addRole(role);
            	        } else if (action.equals("update")) {
            	                // Update existing record
            	        		roleDao.updateRole(role);
            	        }

            	        // Return in the format required by jTable plugin
            	        JSONROOT.put("Result", "OK");
            	        JSONROOT.put("Record", role);

            	        // Convert Java Object to Json
            	        String jsonArray = gson.toJson(JSONROOT);
            	        response.getWriter().print(jsonArray);
            	} catch (Exception ex) {
            	        JSONROOT.put("Result", "ERROR");
            	        JSONROOT.put("Message", ex.getMessage());
            	        String error = gson.toJson(JSONROOT);
            	        response.getWriter().print(error);
            		}
            	} // add, update over
            
            if (action.equals("delete")) {
				try {
					// Delete record
					if (request.getParameter("roleId") != null) {
						int roleId = Integer.parseInt(request.getParameter("roleId"));
						roleDao.deleteRole(roleId);

						// Return in the format required by jTable plugin
						JSONROOT.put("Result", "OK");

						// Convert Java Object to Json
						String jsonArray = gson.toJson(JSONROOT);
						response.getWriter().print(jsonArray);
					}
				} catch (Exception ex) {
					JSONROOT.put("Result", "ERROR");
					JSONROOT.put("Message", ex.getMessage());
					String error = gson.toJson(JSONROOT);
					response.getWriter().print(error);
				}
			}  // delete over
            
        }
	
	}

}
