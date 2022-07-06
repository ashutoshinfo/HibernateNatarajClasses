package info.ashutosh.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import info.ashutosh.entity.StudentInformation;
import info.ashutosh.utility.HibernateUtil;

public class UpdateAssociationMapping {
	public static void main(String[] args) {

		// HibernateUtil.getSessionFactory();
		Session openSession = HibernateUtil.getSession();

		Transaction beginTransaction = openSession.beginTransaction();

		StudentInformation employee = openSession.get(StudentInformation.class, 1l);

		openSession.merge(employee);

		beginTransaction.commit();
		HibernateUtil.closeSession(openSession);
		HibernateUtil.closeSessionFectory();
	}
}
