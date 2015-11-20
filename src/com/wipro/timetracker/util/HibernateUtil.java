package com.wipro.timetracker.util;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author agupt40 This is a helper class to get Hibernate up and running. This
 *         class creates a SessionFactory object which in turn can open up new
 *         Session's. A session is a single-threaded unit of work, the
 *         SessionFactory is a thread-safe global object instantiated once app.
 */

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	final static Logger logger = Logger.getLogger(HibernateUtil.class);

	static {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			sessionFactory = new Configuration().configure()
					.buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			logger.info("Initial SessionFactory creation failed."
					+ ex.getMessage());
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
