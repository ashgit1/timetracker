package com.wipro.timetracker.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.wipro.timetracker.dao.CompOffDao;
import com.wipro.timetracker.daoimpl.CompOffDaoImpl;
import com.wipro.timetracker.model.CompOff;

/**
 * Servlet implementation class WeekendSupportController
 */
public class WeekendSupportController extends HttpServlet {
	
	final static Logger logger = Logger.getLogger(WeekendSupportController.class);
	private static final long serialVersionUID = 1L;
    CompOff compModel;
    CompOffDao compDao;
    
    public WeekendSupportController() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userName = request.getParameter("name");
	    String actionDate = request.getParameter("date");
	    String type = request.getParameter("plan");
		String type_detail = request.getParameter("detail");
		int compoff = Integer.parseInt(request.getParameter("compoff"));
		ArrayList<String> job = new ArrayList<String>();
		String[] time=request.getParameterValues("time");
		String[] comment=request.getParameterValues("comment");
		
		int userId;
		
		if(time!=null){
			
			for(int i=1; i<=time.length;i++){
				
				job.add(request.getParameter("job"+i));
				String taskType = request.getParameter("job"+i);
				compoff=0;
				/*System.out.println("job length : " + job.size()); System.out.println("job value : " + job.toString());
			    System.out.println(userName); System.out.println(actionDate); System.out.println(type);
			    System.out.println(type_detail); System.out.println("time: " + time[i]); System.out.println("comf: " + compoff);*/
				
				compModel = new CompOff();
				compDao = new CompOffDaoImpl();
				// get the id from userName session...
				userId = compDao.getUserID(userName);
				compModel.setUserId(userId); 
				// compModel.setCompOffId(compOffId); automatic increment...
				compModel.setActionDate(actionDate);
				compModel.setType(type);
				compModel.setTypeDetail(type_detail);
				compModel.setTaskType(taskType);
				compModel.setTimeTaken(Integer.parseInt(time[(i-1)]));
				compModel.setTaskDesc(comment[(i-1)]);
				compModel.setCompOffUtilized(compoff);
				
				// save the comp off object...
				if(compModel!=null){
					compDao.addCompOff(compModel);
				}else{
					logger.info("comp off object is null");
				}
				 
				logger.info("one record saved while applying oncall/project");
			}
		}else {
			
			/*System.out.println(userName); System.out.println(actionDate); System.out.println(type);
		    System.out.println(type_detail); System.out.println("comf: " + compoff);*/
		   
		    compModel = new CompOff();
			compDao = new CompOffDaoImpl();
			// get the id from userName session...
			userId = compDao.getUserID(userName);
			compModel.setUserId(userId); 
			//compModel.setCompOffId(1); //automatic increment...
			compModel.setActionDate(actionDate);
			compModel.setType(type);
			compModel.setTypeDetail(type_detail);
			compModel.setTaskType("");
			compModel.setTimeTaken(0);
			compModel.setTaskDesc("");
			compModel.setCompOffUtilized(compoff);
			
			if(compModel!=null){
				compDao.addCompOff(compModel);
			}else{
				logger.info("comp off object is null");
			}
			
			logger.info("one record saved while applying comp-off");
			
		}
		
		
	}

}
