package com.wipro.timetracker.daoimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.wipro.timetracker.dao.EffortsDao;
import com.wipro.timetracker.model.CompOff;
import com.wipro.timetracker.util.HibernateUtil;

public class EffortsDaoImpl implements EffortsDao{

	final static Logger logger = Logger.getLogger(EffortsDaoImpl.class);
	Session session;
	Transaction transaction;
	Query query;
	List<CompOff> compOffForEffortsObj;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CompOff> compOffForEfforts(int userId, String startDate,String endDate) {

		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		String compOffForEffortsQuery = "FROM CompOff co WHERE co.userId = :uid and co.actionDate between :start_Date and :end_Date order by co.actionDate";
		query = session.createQuery(compOffForEffortsQuery);
		query.setParameter("uid", userId);
		query.setParameter("start_Date",startDate);
		query.setParameter("end_Date",endDate);
		compOffForEffortsObj = (List<CompOff>) query.list();
		System.out.println("compoffEfforts size: " + compOffForEffortsObj.size());
		for(CompOff obj : compOffForEffortsObj){
			System.out.println("task desc: " + obj.getTaskDesc());
			System.out.println("time taken: " + obj.getTimeTaken());
			System.out.println("comp off utilized: " + obj.getCompOffUtilized());
			System.out.println("action date: " +obj.getActionDate());
		}
		
		return compOffForEffortsObj;
	}

}
