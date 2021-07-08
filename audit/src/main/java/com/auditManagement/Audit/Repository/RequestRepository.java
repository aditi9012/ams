package com.auditManagement.Audit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.auditManagement.Audit.Entity.Request;

@Repository("requestRepository")
public interface RequestRepository extends CrudRepository<Request, Integer>, JpaRepository<Request,Integer> {
}