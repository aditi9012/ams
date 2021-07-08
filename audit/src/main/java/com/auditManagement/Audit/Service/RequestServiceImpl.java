package com.auditManagement.Audit.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auditManagement.Audit.Entity.Request;
import com.auditManagement.Audit.Repository.RequestRepository;


@Transactional
@Service("requestService")
public class RequestServiceImpl implements RequestService {

	@Autowired
	private RequestRepository requestRepository;

	@Override
	public Request create(Request request) {
		return requestRepository.save(request);
	}
}