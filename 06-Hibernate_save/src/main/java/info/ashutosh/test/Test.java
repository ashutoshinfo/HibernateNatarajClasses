package info.ashutosh.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import info.ashutosh.entity.Product;

public class Test {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("/info/ashutosh/configuration/cfg/hibernate.cfg.xml");

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session openSession = sessionFactory.openSession();

		Product product = new Product();
		product.setName("Ashutosh3");
		product.setPid(3L);

		Transaction beginTransaction = openSession.beginTransaction();

		openSession.persist(product);
		beginTransaction.commit();
	}
}
