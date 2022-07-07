package info.ashutosh.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Bank_Customer")
public class BankCustomer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cId;
	private String cName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Customer_fid", referencedColumnName = "cId")
	private Set<BankAccount> bankAccounts;

	public BankCustomer() {
	}

	public BankCustomer(String cName, Set<BankAccount> bankAccounts) {
		super();
		this.cName = cName;
		this.bankAccounts = bankAccounts;
	}

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Set<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(Set<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BankCustomer [cId=" + cId + ", cName=" + cName + ", bankAccounts=" + bankAccounts + "]";
	}

}
