package com.wipro.timetracker.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.wipro.timetracker.dao.LoginDao;
import com.wipro.timetracker.daoimpl.LoginDaoImpl;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean isUserValid;
	HttpSession session;
	String displayName;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("In Login Controller...");
		String username = request.getParameter("userName");    
	    String password = request.getParameter("password"); 
	    System.out.println("uname: "+ username + ", pass: " + password);
	
	    LoginDao dao = new LoginDaoImpl();
	    isUserValid = dao.validateUser(username, password);
	    if(isUserValid){
	    	displayName = dao.getDisplayName(username);
	    	session = request.getSession();
	        session.setAttribute("displayName", displayName);
	        session.setAttribute("userName", username);
	        response.sendRedirect("weekend_support.jsp");
	    }else{
	    	session = request.getSession();
	        session.setAttribute("invalidUser", username);
	    	response.sendRedirect("login.jsp");
	    }
	    
	}

}
