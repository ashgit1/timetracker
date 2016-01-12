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
import com.wipro.timetracker.dao.EffortsDao;
import com.wipro.timetracker.daoimpl.CompOffDaoImpl;
import com.wipro.timetracker.daoimpl.EffortsDaoImpl;
import com.wipro.timetracker.model.CompOff;

/**
 * Servlet implementation class EffortsController
 */
public class EffortsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(EffortsController.class);
	EffortsDao effortsDao = new EffortsDaoImpl();
	CompOffDao compDao = new CompOffDaoImpl();
	HttpSession session;
	List<CompOff> compOffForEffortsList;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EffortsController() {
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

		System.out.println("Hi in efforts controller...");
		String startDate, endDate, userName;
		int userId;
		session = request.getSession();
		startDate = request.getParameter("startDate");
		endDate = request.getParameter("endDate");
		userName = (String) session.getAttribute("userName");
		// Getting userId based on userName...
		userId = compDao.getUserID(userName);
		System.out.println("userId: " + userId + ", startDate: " + startDate + ", endDate: " + endDate);
		// Getting Data for showing and then saving into Efforts...
		compOffForEffortsList = effortsDao.compOffForEfforts(userId, startDate, endDate);
		if(compOffForEffortsList!=null && compOffForEffortsList.size() !=0){
			session.setAttribute("displayCompOffForEfforts", compOffForEffortsList);
		}else if(compOffForEffortsList.size()==0){
			session.setAttribute("displayCompOffForEffortsEmpty", "Empty");
			session.removeAttribute("displayCompOffForEfforts");
		}
		
		session.setAttribute("startDate", startDate);
		session.setAttribute("endDate", endDate);
		response.sendRedirect("add_efforts.jsp");
	}

}
