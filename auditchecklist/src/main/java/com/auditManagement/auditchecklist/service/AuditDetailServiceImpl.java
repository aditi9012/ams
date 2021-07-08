package com.auditManagement.auditchecklist.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auditManagement.auditchecklist.Repository.AuditDetailRepo;
import com.auditManagement.auditchecklist.Repository.RequestRepo;
import com.auditManagement.auditchecklist.entity.AuditDetail;
import com.auditManagement.auditchecklist.entity.Request;

@Transactional
@Service("requestService")
public class AuditDetailServiceImpl implements AuditDetailService {

	@Autowired
	private AuditDetailRepo auditdetailrepo;
	
	@Autowired 
	private RequestRepo requestrepo;

	@Override
	public AuditDetail create(AuditDetail request) {
		return auditdetailrepo.save(request);
	}

	@Override
	public ArrayList<Request> getAll() {
		return (ArrayList<Request>) requestrepo.findAll();
	}

}