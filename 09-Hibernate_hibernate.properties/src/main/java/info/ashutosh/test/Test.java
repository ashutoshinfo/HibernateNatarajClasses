package info.ashutosh.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import info.ashutosh.entity.Product;
import info.ashutosh.utility.HibernateUtil;

public class Test {
	public static void main(String[] args) {

		HibernateUtil.getSessionFactory();
		Session openSession = HibernateUtil.getSession();

		Product product = new Product();
		product.setName("Ashutosh3");
		// product.setPid(1L);

		Transaction beginTransaction = openSession.beginTransaction();

		openSession.persist(product);
		beginTransaction.commit();
	}
}
