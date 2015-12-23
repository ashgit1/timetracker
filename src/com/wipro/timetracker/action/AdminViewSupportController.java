package com.wipro.timetracker.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.wipro.timetracker.dao.CompOffDao;
import com.wipro.timetracker.daoimpl.CompOffDaoImpl;
import com.wipro.timetracker.model.CompOff;

/**
 * Servlet implementation class AdminViewSupport
 */
public class AdminViewSupportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(AdminViewSupportController.class);
	CompOffDao compDao = new CompOffDaoImpl();   
	HttpSession session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminViewSupportController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userID = request.getParameter("userNameDisplay");
		logger.info("userID: " + userID);
		session = request.getSession();
		List<CompOff> compOffList = compDao.getAllCompOff(Integer.parseInt(userID));
	
		if(compOffList!=null && compOffList.size() !=0){
			session.setAttribute("compOffListBasedOnUserId", compOffList);
		}else if(compOffList.size()==0){
			session.setAttribute("compOffListBasedOnUserIdEmpty", "Empty");
			session.removeAttribute("compOffListBasedOnUserId");
		}
		
		response.sendRedirect("admin_view_support.jsp");
	}

}
