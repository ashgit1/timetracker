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
import com.wipro.timetracker.daoimpl.ProjectDaoImpl;
import com.wipro.timetracker.model.Project;

/**
 * Servlet implementation class ProjectController
 */
public class ProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();
	ProjectDaoImpl projectDao = new ProjectDaoImpl();
    final static Logger logger = Logger.getLogger(ProjectController.class);   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectController() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
        if ( action != null) 
        {
        	List<Project> projectList = new ArrayList<Project>();
        	
        	Gson gson = new GsonBuilder().setPrettyPrinting().create();
            response.setContentType("application/json");
            
            if (action.equals("list")) 
            {
            	try
                { 
            		// Fetch Data from Student Table
            		projectList = projectDao.getAllProjects();

                    //Return in the format required by jTable plugin
                    JSONROOT.put("Result", "OK");
                    JSONROOT.put("Records", projectList);
                    
                    // Convert Java Object to Json
                    String jsonArray = gson.toJson(JSONROOT);
                    System.out.println("list: " + jsonArray);

                    response.getWriter().print(jsonArray);
                }
            	catch(Exception ex){
                    JSONROOT.put("Result", "ERROR while retrieve");
                    JSONROOT.put("Message", ex.getMessage());
                    String error = gson.toJson(JSONROOT);
                    response.getWriter().print(error);
            	} 
            		
            }
            if (action.equals("create") || action.equals("update")) {
            	try{
            	        Project project = new Project();
            	        if (request.getParameter("projectId") != null) {
            	                int projecttId = Integer.parseInt(request.getParameter("projectId"));
            	                project.setProjectId(projecttId);
            	        }

            	        if (request.getParameter("projectName") != null) {
            	                String projectName = request.getParameter("projectName");
            	                project.setProjectName(projectName);
            	        }

            	        if (request.getParameter("projectActive") != null) {
            	                String projectActive = request.getParameter("projectActive");
            	                project.setProjectActive(projectActive);
            	        }

            	        if (request.getParameter("projectDescription") != null) {
            	                String projectDescription = request.getParameter("projectDescription");
            	                project.setProjectDescription(projectDescription);
            	        }
            	        
            	        if (request.getParameter("projectStartDate") != null) {
            	        	String projectStartDate = request.getParameter("projectStartDate");
            	        	logger.info("Start date in Controller : " + projectStartDate);
        	                project.setProjectStartDate(projectStartDate);
            	        }
            	        
            	        if (request.getParameter("projectEndDate") != null) {
            	        	String projectEndDate = request.getParameter("projectEndDate");
        	                logger.info("End date in Controller : " + projectEndDate);
        	                project.setProjectEndDate(projectEndDate);
            	        }
            	        
            	        if (request.getParameter("projectManagerUserId") != null) {
        	                int projectManagerUserId = Integer.parseInt(request.getParameter("projectManagerUserId"));
        	                project.setProjectManagerUserId(projectManagerUserId);
        	        }

            	        if (action.equals("create")) {
            	                // Create new record
            	                projectDao.addProject(project);
            	        } else if (action.equals("update")) {
            	                // Update existing record
            	        		projectDao.updateProject(project);
            	        }

            	        // Return in the format required by jTable plugin
            	        JSONROOT.put("Result", "OK");
            	        JSONROOT.put("Record", project);

            	        // Convert Java Object to Json
            	        String jsonArray = gson.toJson(JSONROOT);
            	        response.getWriter().print(jsonArray);
            	} catch (Exception ex) {
            	        JSONROOT.put("Result", "ERROR");
            	        JSONROOT.put("Message", ex.getMessage());
            	        String error = gson.toJson(JSONROOT);
            	        response.getWriter().print(error);
            	}
            	}
            
			if (action.equals("delete")) {
				try {
					// Delete record
					if (request.getParameter("projectId") != null) {
						int projectId = Integer.parseInt(request.getParameter("projectId"));
						projectDao.deleteProject(projectId);

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
			}
        }
	
	}

}
