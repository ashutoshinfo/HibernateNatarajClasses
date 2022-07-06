package info.ashutosh.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;

import info.ashutosh.utility.HibernateUtil;

public class SelectAssociationMapping {
	public static void main(String[] args) {

		// HibernateUtil.getSessionFactory();
		Session openSession = HibernateUtil.getSession();

		SelectionQuery<?> createSelectionQuery = openSession.createSelectionQuery("from StudentInformation where sId=1");

		List<?> resultList = createSelectionQuery.getResultList();

		for (Object object : resultList) {
			System.out.println(object);
		}

		HibernateUtil.closeSession(openSession);
		HibernateUtil.closeSessionFectory();
	}
}
