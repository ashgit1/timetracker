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
import com.wipro.timetracker.daoimpl.UsersDaoImpl;
import com.wipro.timetracker.model.Users;

/**
 * Servlet implementation class UserController
 */

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();
	UsersDaoImpl userDao = new UsersDaoImpl();
	List<Users> userList;
    final static Logger logger = Logger.getLogger(UserController.class); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		
		if ( action != null){
			
			userList = new ArrayList<Users>();
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
            response.setContentType("application/json");
            
            if (action.equals("list")){
            	try{ 
            		
            		userList = userDao.getAllUsers();
            		
            		//Return in the format required by jTable plugin
                    JSONROOT.put("Result", "OK");
                    JSONROOT.put("Records", userList);
                    
                    // Convert Java Object to Json
                    String jsonArray = gson.toJson(JSONROOT);
                    System.out.println("Users list: " + jsonArray);

                    response.getWriter().print(jsonArray);
            		
                }catch(Exception ex){
                    JSONROOT.put("Result", "ERROR");
                    JSONROOT.put("Message", ex.getMessage());
                    String error = gson.toJson(JSONROOT);
                    response.getWriter().print(error);
            	} 
            	
            } // list over
            
            if(action.equals("getProjectNames")){
            	
            	System.out.println("project called ....");
				HashMap<Integer, String> projectsMap = new HashMap<Integer, String>();
				
				try{
            	projectsMap = (HashMap<Integer, String>) userDao.projectNames();
            	
            	//Return in the format required by jTable plugin
                JSONROOT.put("Result", "OK");
                JSONROOT.put("Options", projectsMap);
                
                // Convert Java Object to Json
                String jsonProjectArray = gson.toJson(JSONROOT);
                System.out.println("projects options : " + jsonProjectArray);

                response.getWriter().print(jsonProjectArray);
				}catch(Exception ex){
					JSONROOT.put("Result", "ERROR");
                    JSONROOT.put("Message", ex.getMessage());
                    String error = gson.toJson(JSONROOT);
                    response.getWriter().print(error);
				}
            }
            
		}
	
	}

}
