package com.dis.audit.service.create;


import com.dis.audit.common.model.database.FailedAudit;
import com.dis.audit.common.model.messaging.AuditMessage;
import com.dis.audit.controller.create.dto.AuditCreateRequest;
import com.dis.audit.model.audit.Audit;

public interface IAuditCreateService {

    Audit log(AuditCreateRequest auditCreateRequest);

    void log(AuditMessage auditMessage);

    void log(FailedAudit failedAudit);

}
