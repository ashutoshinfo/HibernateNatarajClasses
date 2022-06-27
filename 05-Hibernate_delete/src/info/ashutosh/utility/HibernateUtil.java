package info.ashutosh.utility;

import javax.persistence.RollbackException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	static {
		try {
			Configuration configuration = new Configuration();
			configuration.configure("/info/ashutosh/configuration/cfg/hibernate.cfg.xml");
			sessionFactory = (SessionFactory) configuration.buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} // try-catch

	}// static

	public static SessionFactory getSessionFactory() {
		if (sessionFactory != null) {

			return sessionFactory;
		} else {

			throw new RollbackException("Invalid Session Fectory Object !");
		}
	}// getSessionFactory()

	public static Session getSession() {
		Session session = null;
		if (sessionFactory != null) {
			session = sessionFactory.openSession();
		}
		return session;
	}// getSession()

	public void closeSession(Session session) {
		if (session != null) {
			session.close();
		}
	}// closeSession()

	public void closeSessionFectory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}// closeSessionFectory()

}
