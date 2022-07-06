package info.ashutosh.entity;

import java.io.Serializable;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
//@DynamicInsert(true)
//@DynamicUpdate(true)
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long eId;
	String eName;
	Double eSalary;// if != wrapper type then participate in insertion else null value inserted

	@Embedded
	JobRole jobRole;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String eName, Double eSalary, JobRole jobRole) {
		super();
		this.eName = eName;
		this.eSalary = eSalary;
		this.jobRole = jobRole;
	}

	public Long geteId() {
		return eId;
	}

	public void seteId(Long eId) {
		this.eId = eId;
	}

	public String getName() {
		return eName;
	}

	public void setName(String name) {
		this.eName = name;
	}

	public Double getSalary() {
		return eSalary;
	}

	public void setSalary(Double salary) {
		this.eSalary = salary;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public Double geteSalary() {
		return eSalary;
	}

	public void seteSalary(Double eSalary) {
		this.eSalary = eSalary;
	}

	public JobRole getJobRole() {
		return jobRole;
	}

	public void setJobRole(JobRole jobRole) {
		this.jobRole = jobRole;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", eSalary=" + eSalary + ", jobRole=" + jobRole + "]";
	}
	
	

}