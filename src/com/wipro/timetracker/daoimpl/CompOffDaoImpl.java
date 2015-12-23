package com.wipro.timetracker.daoimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wipro.timetracker.dao.CompOffDao;
import com.wipro.timetracker.model.CompOff;
import com.wipro.timetracker.util.HibernateUtil;

public class CompOffDaoImpl implements CompOffDao{

	CompOff compOffObjSave;
	
	final static Logger logger = Logger.getLogger(CompOffDaoImpl.class);
	Session session;
	Transaction transaction;
	int userID;
	List<CompOff> allComfOff;
	String roleName;
	
	
	@Override
	public void addCompOff(CompOff compOffObj) {
		
		session = HibernateUtil.getSessionFactory().openSession();
		transaction =  session.beginTransaction();
		session.save(compOffObj);
        transaction.commit();
        session.close();
	}

	@Override
	public void updateCompOff(CompOff obj) {
		
	}

	@Override
	public void deleteCompOff(int compOffID) {
		
		session = HibernateUtil.getSessionFactory().openSession();
		transaction =  session.beginTransaction();
		
		String deleteCompOff = "DELETE FROM CompOff co WHERE co.compOffId = :comp_off_id";
		Query query = session.createQuery(deleteCompOff);
		
		query.setParameter("comp_off_id", compOffID);
		if(query.executeUpdate() == 1){
			logger.info("compoff deleted for : " +compOffID);
		}

		transaction.commit();
        session.close();
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CompOff> getAllCompOff(int userID) {
		
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		String getAllCompOffQuery = "FROM CompOff co WHERE co.userId = :uid";
		Query query = session.createQuery(getAllCompOffQuery);
		query.setParameter("uid", userID);
		allComfOff = (List<CompOff>) query.list();
		
		if(allComfOff.size() > 0){
			logger.info("compoff list size: " +allComfOff.size());
			System.out.println("compoff list size: " +allComfOff.size());
		}else{
			transaction.rollback();
			session.close();
		}
		return allComfOff;
	}

	@Override
	public int getUserID(String userName) {
		
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		String getUserIDQuery = "SELECT u.userId FROM Users u WHERE u.userName = :uname";
		userID = (Integer) session.createQuery(getUserIDQuery).setString("uname", userName).uniqueResult();
		transaction.commit();
		session.close();
		return userID;
	}

	@Override
	public String getRoleName(int userId) {
		
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		String getUserRoleQuery = "select r.roleName from Role r where r.roleId = ( select u.roleId from Users u where u.userId = :userId )";
		roleName = (String) session.createQuery(getUserRoleQuery).setInteger("userId", userId).uniqueResult();
		transaction.commit();
		session.close();
		return roleName;
		
	}

}
