package info.ashutosh.entity;

import java.io.Serializable;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

@Entity
@DynamicInsert(true)
@DynamicUpdate(true)
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long pid;
	String name;
	Double price;// if != wrapper type then participate in insertion else null value inserted
	@Version
	Long upadteCount;

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

	public Long getUpadteCount() {
		return upadteCount;
	}

	public void setUpadteCount(Long upadteCount) {
		this.upadteCount = upadteCount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
