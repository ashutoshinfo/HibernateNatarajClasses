package info.ashutosh.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import info.ashutosh.entity.Product;
import info.ashutosh.utility.HibernateUtil;

public class Test {
	public static void main(String[] args) {

		// HibernateUtil.getSessionFactory();
		Session openSession = HibernateUtil.getSession();
		Product product = openSession.get(Product.class, 1L);
		if (product != null) {
			product.setName("3st upadted");
			product.setPrice(10d);
			openSession.persist(product);

		} else {
			System.out.println("PRoduct Not Foound !");
			Product product2 = new Product();
			product2.setName("1st Fresh");
			product2.setPrice(10d);
			openSession.persist(product2);
		}

		Transaction beginTransaction = openSession.beginTransaction();

		beginTransaction.commit();

		HibernateUtil.closeSession(openSession);
		HibernateUtil.closeSessionFectory();
	}
}
