package com.wipro.timetracker.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.wipro.timetracker.dao.UsersDao;
import com.wipro.timetracker.daoimpl.UsersDaoImpl;

/**
 * Servlet implementation class GetUsersBasedProject
 */
public class GetUsersBasedProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UsersDao userDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUsersBasedProjectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String dd = request.getParameter("dd"); // ID of child DD to fill options for.
		 String val = request.getParameter("val"); // Value of parent DD to find associated child DD options for.
		 
		 System.out.println("childId: " + dd + " parentVal: " + val);
		 
		 userDao = new UsersDaoImpl();
		 
		 Map<Integer, String> options = userDao.getUserDisplayNameBasedOnProject(val);
		 String json = new Gson().toJson(options);
		 System.out.println("User Json String: " + json);
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
		 response.getWriter().write(json);
	}

}
