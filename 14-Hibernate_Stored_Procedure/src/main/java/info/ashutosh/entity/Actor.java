package info.ashutosh.entity;

import java.io.Serializable;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;

@Entity
@DynamicInsert(true)
@DynamicUpdate(true)
//@NamedNativeQuery(name = "getByStartingCarecter", query = "get_all_actors_Name_start_with_(?)", resultClass = Actor.class, callable = true)
//@NamedStoredProcedureQuery(name = "getByStartingCarecter", procedureName = "get_all_actors_Name_start_with_", parameters = { @StoredProcedureParameter(mode = ParameterMode.IN, name = "charAt", type = String.class), @StoredProcedureParameter(mode = ParameterMode.OUT, type = Actor.class, name = "List") })

@NamedStoredProcedureQuery(
    name = "getByStartingCarecter", 
    procedureName = "get_all_actors_Name_start_with_", 
    resultClasses = Actor.class, 
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class)
    }
)
public class Actor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long pid;
	String name;
	Double price;// if != wrapper type then participate in insertion else null value inserted

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Actor [pid=" + pid + ", name=" + name + ", price=" + price + "]";
	}

}
