package info.ashutosh.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import info.ashutosh.entity.BankAccount;
import info.ashutosh.entity.BankCustomer;
import info.ashutosh.utility.HibernateUtil;

public class UpdateAssociationMapping {
	public static void main(String[] args) {

		// HibernateUtil.getSessionFactory();
		Session openSession = HibernateUtil.getSession();

		Transaction beginTransaction = openSession.beginTransaction();

		BankCustomer bankCustomer = openSession.get(BankCustomer.class, 1l);
		bankCustomer.setcName("Ashutosh Updated");
		
		Set<BankAccount> bankAccounts = bankCustomer.getBankAccounts();
		for (BankAccount bankAccount : bankAccounts) {
			bankAccount.setAccType("Current Updated");
		}
		
		

		openSession.merge(bankCustomer);

		beginTransaction.commit();
		HibernateUtil.closeSession(openSession);
		HibernateUtil.closeSessionFectory();
	}
}
