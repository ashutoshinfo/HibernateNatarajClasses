package info.ashutosh.test;

import org.hibernate.Session;

import info.ashutosh.utility.HibernateUtil;

public class Test {
	public static void main(String[] args) {

		// HibernateUtil.getSessionFactory();
		Session openSession = HibernateUtil.getSession();

		HibernateUtil.closeSession(openSession);
		HibernateUtil.closeSessionFectory();
	}
}
