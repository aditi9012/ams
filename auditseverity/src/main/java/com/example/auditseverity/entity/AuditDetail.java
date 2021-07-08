package com.example.auditseverity.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "AuditDetail")
public class AuditDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "auditId")
	private int auditId;
	public int getId() {
		return auditId;
	}
	public void setId(int auditId) {
		this.auditId = auditId;
	}
	
	@Column(name = "AuditType")
	private String AuditType;
	
	@Column(name = "Q1")
	private String Q1;
	@Column(name = "Q2")
	private String Q2;
	@Column(name = "Q3")
	private String Q3;
	@Column(name = "Q4")
	private String Q4;
	@Column(name = "Q5")
	private String Q5;
	

	
	
	public String getQ1() {
		return Q1;
	}
	public void setQ1(String q1) {
		Q1 = q1;
	}
	public String getQ2() {
		return Q2;
	}
	public void setQ2(String q2) {
		Q2 = q2;
	}
	public String getQ3() {
		return Q3;
	}
	public void setQ3(String q3) {
		Q3 = q3;
	}
	public String getQ4() {
		return Q4;
	}
	public void setQ4(String q4) {
		Q4 = q4;
	}
	public String getQ5() {
		return Q5;
	}
	public void setQ5(String q5) {
		Q5 = q5;
	}
	public String getAuditType() {
		return AuditType;
	}
	public void setAuditType(String auditType) {
		AuditType = auditType;
	}
	
	
	
}
