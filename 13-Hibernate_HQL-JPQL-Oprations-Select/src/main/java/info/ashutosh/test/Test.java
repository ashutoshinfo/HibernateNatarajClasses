package info.ashutosh.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;

import info.ashutosh.utility.HibernateUtil;

public class Test {
	public static void main(String[] args) {

		// HibernateUtil.getSessionFactory();
		Session openSession = HibernateUtil.getSession();
		//Product product = openSession.get(Product.class, 1L);
		SelectionQuery<?> createSelectionQuery = openSession.createSelectionQuery("from Actor");
		List<?> resultList = createSelectionQuery.getResultList();
		
		for (Object object : resultList) {
			System.out.println(object);
		}


		HibernateUtil.closeSession(openSession);
		HibernateUtil.closeSessionFectory();
	}
}
