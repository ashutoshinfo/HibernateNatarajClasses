package info.ashutosh.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import info.ashutosh.entity.BankAccount;
import info.ashutosh.entity.BankCustomer;
import info.ashutosh.utility.HibernateUtil;

public class InsertAssociationMapping {
	public static void main(String[] args) {

		// HibernateUtil.getSessionFactory();
		Session openSession = HibernateUtil.getSession();

		Transaction beginTransaction = openSession.beginTransaction();

		BankCustomer bc1 = new BankCustomer("Ashutosh", Set.of(new BankAccount("Saving", 12345l)));

		openSession.persist(bc1);

		beginTransaction.commit();
		HibernateUtil.closeSession(openSession);
		HibernateUtil.closeSessionFectory();
	}
}
