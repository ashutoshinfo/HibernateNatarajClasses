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

		Product product = new Product();
		product.setPid(4l);
		product.setName("Updated2");

		Transaction beginTransaction = openSession.beginTransaction();

		// 3 Possibility in saveOrUpdate()
		// Select + Update
		// Select + insert
		// Select
		openSession.saveOrUpdate(product);

		beginTransaction.commit();

		openSession.close();
		sessionFactory.close();

	}
}
