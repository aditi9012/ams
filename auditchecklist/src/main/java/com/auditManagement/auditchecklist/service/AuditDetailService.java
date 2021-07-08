package com.auditManagement.auditchecklist.service;

import java.util.ArrayList;

import com.auditManagement.auditchecklist.entity.AuditDetail;
import com.auditManagement.auditchecklist.entity.Request;

public interface AuditDetailService {

	public AuditDetail create(AuditDetail request);
	public ArrayList<Request> getAll();

}