package info.ashutosh.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;

import info.ashutosh.utility.HibernateUtil;

public class Test {
	public static void main(String[] args) {

		// HibernateUtil.getSessionFactory();
		Session openSession = HibernateUtil.getSession();
		// NativeQuery<Actor> createNativeQuery = openSession.createNativeQuery("getByStartingCarecter", Actor.class);
		ProcedureCall namedProcedureCall = openSession.getNamedProcedureCall("getByStartingCarecter");
		namedProcedureCall.setParameter(1, "k");

		List<?> resultList = namedProcedureCall.getResultList();

		for (Object object : resultList) {
			System.out.println(object);
		}

		HibernateUtil.closeSession(openSession);
		HibernateUtil.closeSessionFectory();
	}
}
