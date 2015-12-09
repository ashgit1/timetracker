package com.wipro.timetracker.daoimpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wipro.timetracker.dao.LoginDao;
import com.wipro.timetracker.util.HibernateUtil;

public class LoginDaoImpl implements LoginDao{

	final static Logger logger = Logger.getLogger(LoginDaoImpl.class);
	Session session;
	Transaction transaction;
	boolean isValidUser;
	String displayName;
	
	public LoginDaoImpl(){
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean validateUser(String username, String password) {
		
		session = HibernateUtil.getSessionFactory().openSession();
		transaction =  session.beginTransaction();
        System.out.println("user: " + username +", pass: " +password);
        String valideUserQuery = "FROM Users u WHERE u.userName = :uname and u.password =:passwd";
        System.out.println("query: " + valideUserQuery);
        Query query = session.createQuery(valideUserQuery);
        query.setParameter("uname", username);
        query.setParameter("passwd", password);
        
        List<Integer> result = (List<Integer>)query.list();
        if(result.size() > 0){
        	isValidUser=true;
        }
        	
        transaction.commit();
        session.close();
        
		return isValidUser;
	}

	
	@Override
	public String getDisplayName(String username) {

		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		String displayQuery = "SELECT u.displayName FROM Users u WHERE u.userName = :uname";
		displayName = (String) session.createQuery(displayQuery).setString("uname", username).uniqueResult();
		transaction.commit();
		session.close();
		return displayName;

	}

}
