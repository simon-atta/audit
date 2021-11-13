package com.dis.audit.repository;


import com.dis.audit.model.audit.Audit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IAuditRepository extends MongoRepository<Audit, String> {

}
