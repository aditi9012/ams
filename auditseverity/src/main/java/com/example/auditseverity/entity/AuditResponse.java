package com.example.auditseverity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AuditResponse")
public class AuditResponse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "auditId")
	private int auditId;
	@Column(name = "ProjectExecutionStatus")
	private String ProjectExecutionStatus;
	@Column(name = "RemedialActionDuration")
	private String RemedialActionDuration;
	public int getAuditId() {
		return auditId;
	}
	public void setAuditId(int auditId) {
		this.auditId = auditId;
	}
	public String getProjectExecutionStatus() {
		return ProjectExecutionStatus;
	}
	public void setProjectExecutionStatus(String projectExecutionStatus) {
		ProjectExecutionStatus = projectExecutionStatus;
	}
	public String getRemedialActionDuration() {
		return RemedialActionDuration;
	}
	public void setRemedialActionDuration(String remedialActionDuration) {
		RemedialActionDuration = remedialActionDuration;
	}

}
