package com.example.auditseverity.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.auditseverity.entity.AuditResponse;

public interface AuditSeverityRepo extends CrudRepository<AuditResponse, Integer> {

}
