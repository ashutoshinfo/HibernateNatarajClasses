package info.ashutosh.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import info.ashutosh.entity.Employee;
import info.ashutosh.entity.JobRole;
import info.ashutosh.utility.HibernateUtil;

public class UpdateAssociationMapping {
	public static void main(String[] args) {

		// HibernateUtil.getSessionFactory();
		Session openSession = HibernateUtil.getSession();

		Transaction beginTransaction = openSession.beginTransaction();

		Employee employee = openSession.get(Employee.class, 1l);

		employee.seteName("Ashutosh Patel");
		employee.seteSalary(55000d);

		employee.setJobRole(new JobRole("Java Profacional Develoepr", "Technicals"));

		openSession.merge(employee);

		beginTransaction.commit();
		HibernateUtil.closeSession(openSession);
		HibernateUtil.closeSessionFectory();
	}
}
