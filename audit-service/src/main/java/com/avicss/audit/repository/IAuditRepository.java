package com.avicss.audit.repository;


import com.avicss.audit.model.audit.Audit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IAuditRepository extends MongoRepository<Audit, String> {

}
