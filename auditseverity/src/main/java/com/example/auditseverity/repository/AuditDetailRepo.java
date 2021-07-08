package com.example.auditseverity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.auditseverity.entity.AuditDetail;


@Repository("requestRepository")
public interface AuditDetailRepo extends CrudRepository<AuditDetail, Integer> {
}