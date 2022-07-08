package info.ashutosh.test;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.SelectionQuery;

import info.ashutosh.entity.BankAccount;
import info.ashutosh.entity.BankCustomer;
import info.ashutosh.utility.HibernateUtil;

public class SelectAssociationMapping {
	public static void main(String[] args) {

		// HibernateUtil.getSessionFactory();
		Session openSession = HibernateUtil.getSession();
		
		Transaction beginTransaction = openSession.beginTransaction();
		
		BankCustomer bc1 = new BankCustomer("Ashutosh", Set.of(new BankAccount("Saving", 123485l)));

		openSession.persist(bc1);
		beginTransaction.commit();

		SelectionQuery<?> createSelectionQuery = openSession.createSelectionQuery("from BankAccount");

		List<?> resultList = createSelectionQuery.getResultList();

		for (Object object : resultList) {
			BankAccount object2 = (BankAccount) object;
			System.out.println(object2);
		}

		HibernateUtil.closeSession(openSession);
		HibernateUtil.closeSessionFectory();
	}
}
