package com.avicss.audit.service.create;


import com.avicss.audit.controller.create.dto.AuditCreateRequest;
import com.avicss.audit.model.audit.Audit;
import com.avicss.audit.model.database.FailedAudit;
import com.avicss.audit.model.messaging.AuditMessage;

public interface IAuditCreateService {

    Audit log(AuditCreateRequest auditCreateRequest);

    void log(AuditMessage auditMessage);

    void log(FailedAudit failedAudit);

}
