package info.ashutosh.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.annotations.ListIndexBase;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;

@Entity
//@DynamicInsert(true)
//@DynamicUpdate(true)

@Table(name = "Student_Information")

public class StudentInformation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long sId;
	String sName;

	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "Student_Friends")
	@JoinColumn(name = "STUD_ID", referencedColumnName = "sId")
	@OrderColumn(name = "FRIEND_INDEX")
	@ListIndexBase(value = 1)
	List<String> sFriends;

	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "Student_MobileNos")
	@JoinColumn(name = "STUD_ID", referencedColumnName = "sId")
	@Column(name = "NUMBER")
	Set<String> sMobileNumbes;

	@ElementCollection // If one of the group collection attribute is annotated with LAZY then Whole Collection will not load at once
	@JoinTable(name = "Student_Certificates")
	@JoinColumn(name = "STUD_ID", referencedColumnName = "sId")
	@MapKeyColumn(name = "CERTIFICATE_TYPE", length = 20)
	Map<String, Long> idCertificates;

	public StudentInformation() {
	}

	public StudentInformation(String sName, List<String> sFriends, Set<String> sMobileNumbes, Map<String, Long> idCertificates) {
		super();
		this.sName = sName;
		this.sFriends = sFriends;
		this.sMobileNumbes = sMobileNumbes;
		this.idCertificates = idCertificates;
	}

	protected Long getsId() {
		return sId;
	}

	protected void setsId(Long sId) {
		this.sId = sId;
	}

	protected String getsName() {
		return sName;
	}

	protected void setsName(String sName) {
		this.sName = sName;
	}

	protected List<String> getsFriends() {
		return sFriends;
	}

	protected void setsFriends(List<String> sFriends) {
		this.sFriends = sFriends;
	}

	protected Set<String> getsMobileNumbes() {
		return sMobileNumbes;
	}

	protected void setsMobileNumbes(Set<String> sMobileNumbes) {
		this.sMobileNumbes = sMobileNumbes;
	}

	protected Map<String, Long> getIdCertificates() {
		return idCertificates;
	}

	protected void setIdCertificates(Map<String, Long> idCertificates) {
		this.idCertificates = idCertificates;
	}

	protected static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "StudentInformation [sId=" + sId + ", sName=" + sName + ", sFriends=" + sFriends + ", sMobileNumbes=" + sMobileNumbes + ", idCertificates=" + idCertificates + "]";
	}

}
