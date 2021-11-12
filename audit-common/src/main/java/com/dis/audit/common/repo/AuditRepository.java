package com.dis.audit.common.repo;


import com.dis.audit.common.model.database.FailedAudit;
import org.springframework.data.repository.CrudRepository;

public interface AuditRepository extends CrudRepository<FailedAudit, Long> {

}
