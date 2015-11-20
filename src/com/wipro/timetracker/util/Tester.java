/**
 * 
 */
package com.wipro.timetracker.util;

/**
 * @author agupt40
 * The purpose of this class is to do sanity testing
 */

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.wipro.timetracker.daoimpl.ProjectDaoImpl;
import com.wipro.timetracker.model.Project;

public class Tester {
	
	final static Logger logger = Logger.getLogger(Tester.class);
	
	
	public static void main(String[] args) throws Exception {

		 //DBUtil.getCon();
		Configuration configuration;
		SessionFactory sessionFactory;
		Session session = null;
		Transaction transaction;
		try {
        configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
       /* Project pro = new Project();
        pro.setProjectName("XYZ");
        pro.setProjectManagerUserId(1);
        pro.setProjectDescription("ABC");
        pro.setProjectId(2);
        pro.setProjectStartDate(new java.util.Date());
        pro.setProjectEndDate(new java.util.Date());
        pro.setProjectActive("Yes");
        session.save(pro);*/
        transaction.commit();
       
       // System.out.println("\n\n Object saved \n");
        
        ProjectDaoImpl obj = new ProjectDaoImpl();
        obj.getAllProjects();
        
        

   } catch (HibernateException e) {
   	logger.error("error message : " + e.getMessage());
   }	finally{
   	//session.close();
   }
		
	}

}
