package com.auditManagement.auditchecklist.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.auditManagement.auditchecklist.entity.AuditDetail;

@Repository("requestRepository")
public interface AuditDetailRepo extends CrudRepository<AuditDetail, Integer> {
}