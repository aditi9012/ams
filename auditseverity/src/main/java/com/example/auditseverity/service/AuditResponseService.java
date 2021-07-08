package com.example.auditseverity.service;

import java.util.ArrayList;

import com.example.auditseverity.entity.AuditDetail;
import com.example.auditseverity.entity.AuditResponse;


public interface AuditResponseService {
	
	public AuditResponse create(AuditResponse request);
	public ArrayList<AuditDetail> getAll();

}
