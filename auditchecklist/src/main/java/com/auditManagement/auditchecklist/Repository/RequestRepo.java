package com.auditManagement.auditchecklist.Repository;

import org.springframework.data.repository.CrudRepository;

import com.auditManagement.auditchecklist.entity.Request;

public interface RequestRepo extends CrudRepository<Request, Integer>{

}
