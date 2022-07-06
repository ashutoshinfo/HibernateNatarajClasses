package info.ashutosh.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import info.ashutosh.entity.Employee;
import info.ashutosh.entity.JobRole;
import info.ashutosh.utility.HibernateUtil;

public class InsertAssociationMapping {
	public static void main(String[] args) {

		// HibernateUtil.getSessionFactory();
		Session openSession = HibernateUtil.getSession();

		Transaction beginTransaction = openSession.beginTransaction();

		openSession.persist(new Employee("Ashutosh", 50000d, new JobRole("Java Developer", "Tecnical")));

		beginTransaction.commit();
		HibernateUtil.closeSession(openSession);
		HibernateUtil.closeSessionFectory();
	}
}
