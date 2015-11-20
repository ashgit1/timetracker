/**
 * 
 */
package com.wipro.timetracker.util;

import org.apache.log4j.Logger;
import org.hibernate.Session;

/**
 * @author agupt40
 * This class is used to create all the table reading from hibernate.cfg file.
 */

public class CreateTables {
	
	final static Logger logger = Logger.getLogger(CreateTables.class);

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.getTransaction().commit();
        logger.info("Tables created");
        session.close();
	}

}
