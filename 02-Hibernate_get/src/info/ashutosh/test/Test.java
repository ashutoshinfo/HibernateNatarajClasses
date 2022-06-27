package info.ashutosh.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import info.ashutosh.entity.Product;
import info.ashutosh.utility.HibernateUtil;

public class Test {
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session openSession = HibernateUtil.getSession();

		Product product2 = openSession.get(Product.class, 10l); // Use Load Or Get

		if (product2 != null) {
			try {
				System.out.println(product2);
				
			} catch (Exception e) {
				
				System.out.println("Record Not Found ! - With Exception.");
			}
		} else {
			System.out.println("Record Not Found !");
		}

		openSession.close();
		sessionFactory.close();

	}
}
