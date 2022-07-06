package info.ashutosh.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

//@DynamicInsert(true)
//@DynamicUpdate(true)
@Embeddable
public class JobRole implements Serializable {

	private static final long serialVersionUID = 1L;

	String jPosition;
	String jRole;// if != wrapper type then participate in insertion else null value inserted

	public JobRole() {
	}

	public JobRole(String jPosition, String jRole) {
		super();
		this.jPosition = jPosition;
		this.jRole = jRole;
	}

	public String getjPosition() {
		return jPosition;
	}

	public void setjPosition(String jPosition) {
		this.jPosition = jPosition;
	}

	public String getjRole() {
		return jRole;
	}

	public void setjRole(String jRole) {
		this.jRole = jRole;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "JobRole [jPosition=" + jPosition + ", jRole=" + jRole + "]";
	}
	
	

}