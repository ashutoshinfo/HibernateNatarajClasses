package info.ashutosh.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import info.ashutosh.entity.Product;
import info.ashutosh.utility.HibernateUtil;

public class Test {
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session openSession = HibernateUtil.getSession();

		Long idd = 3L;
		Product product = openSession.get(Product.class, idd);

		Transaction beginTransaction = openSession.beginTransaction();
		if (product != null) {

			openSession.delete(product);
			System.out.println("Record Deleted !");
		} else {

			System.out.println("Record Not Found !");
		}

		beginTransaction.commit();

		openSession.close();
		sessionFactory.close();

	}
}
