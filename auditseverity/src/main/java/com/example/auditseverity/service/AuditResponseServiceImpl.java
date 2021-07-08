package com.example.auditseverity.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.auditseverity.entity.AuditDetail;
import com.example.auditseverity.entity.AuditResponse;
import com.example.auditseverity.repository.AuditDetailRepo;
import com.example.auditseverity.repository.AuditSeverityRepo;


@Transactional
@Service("requestService")
public class AuditResponseServiceImpl implements AuditResponseService {

	@Autowired
	private AuditDetailRepo auditdetailrepo;
	
	@Autowired 
	private AuditSeverityRepo responseRepo;

	@Override
	public AuditResponse create(AuditResponse request) {
		return responseRepo.save(request);
	}

	@Override
	public ArrayList<AuditDetail> getAll() {
		return (ArrayList<AuditDetail>) auditdetailrepo.findAll();
	}

}