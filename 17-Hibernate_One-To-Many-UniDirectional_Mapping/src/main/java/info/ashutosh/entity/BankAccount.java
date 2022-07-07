package info.ashutosh.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bank_account")
public class BankAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long bid;
	String accType;

	@Column(unique = true)
	Long accNumebr;

	public BankAccount() {
	}

	public BankAccount(String accType, Long accNumebr) {
		super();
		this.accType = accType;
		this.accNumebr = accNumebr;
	}

	public Long getBid() {
		return bid;
	}

	public void setBid(Long bid) {
		this.bid = bid;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public Long getAccNumebr() {
		return accNumebr;
	}

	public void setAccNumebr(Long accNumebr) {
		this.accNumebr = accNumebr;
	}

	@Override
	public String toString() {
		return "BankAccount [bid=" + bid + ", accType=" + accType + ", accNumebr=" + accNumebr + "]";
	}

}
