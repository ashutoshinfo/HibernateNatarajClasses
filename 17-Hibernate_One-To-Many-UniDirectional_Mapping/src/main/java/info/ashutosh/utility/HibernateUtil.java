package info.ashutosh.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	static {
		try {
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
			StandardServiceRegistry build = builder.configure("hibernate.cfg.xml").build();

			Configuration configuration = new Configuration();
			sessionFactory = configuration.buildSessionFactory(build);
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

			throw new RuntimeException("Invalid Session Fectory Object !");
		}
	}// getSessionFactory()

	public static Session getSession() {
		Session session = null;
		if (sessionFactory != null) {
			session = sessionFactory.openSession();
		}
		return session;
	}// getSession()

	public static void closeSession(Session session) {
		if (session != null) {
			session.close();
		}
	}// closeSession()

	public static void closeSessionFectory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}// closeSessionFectory()

}
