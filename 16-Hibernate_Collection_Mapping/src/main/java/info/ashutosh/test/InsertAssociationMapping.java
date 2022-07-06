package info.ashutosh.test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import info.ashutosh.entity.StudentInformation;
import info.ashutosh.utility.HibernateUtil;

public class InsertAssociationMapping {
	public static void main(String[] args) {

		// HibernateUtil.getSessionFactory();
		Session openSession = HibernateUtil.getSession();

		Transaction beginTransaction = openSession.beginTransaction();

		List<String> friends = List.of("Friend1", "Friend2", "Friend13");
		Set<String> mono = Set.of("1111111111", "2222222222", "3333333333");
		Map<String, Long> carti = Map.of("ADHAR", 2312343l, "LICENS", 233423423l, "PANCARD", 2457235l);

		StudentInformation information = new StudentInformation("Ashutosh", friends, mono, carti);
		openSession.persist(information);

		List<String> friends2 = List.of("Friend1", "Friend2", "Friend13");
		Set<String> mono2 = Set.of("1111111111", "2222222222", "3333333333");
		Map<String, Long> carti2 = Map.of("ADHAR", 2312343l, "LICENS", 233423423l, "PANCARD", 2457235l);

		StudentInformation information2 = new StudentInformation("Ashutosh", friends2, mono2, carti2);
		openSession.persist(information2);


		beginTransaction.commit();
		HibernateUtil.closeSession(openSession);
		HibernateUtil.closeSessionFectory();
	}
}
