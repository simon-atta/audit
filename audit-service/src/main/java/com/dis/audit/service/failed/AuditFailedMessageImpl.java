package com.dis.audit.service.failed;

import com.dis.audit.common.model.database.FailedAudit;
import com.dis.audit.common.repo.AuditRepository;
import com.dis.audit.service.create.IAuditCreateService;
import org.springframework.stereotype.Service;


@Service
public class AuditFailedMessageImpl implements IAuditFailedMessage {

    private final AuditRepository auditRepository;

    private final IAuditCreateService auditCreateService;

    public AuditFailedMessageImpl(AuditRepository auditRepository,
                                  IAuditCreateService auditCreateService) {
        this.auditRepository = auditRepository;
        this.auditCreateService = auditCreateService;
    }

    @Override
    public void syncFailedAuditMessage() {
        for (FailedAudit failedAudit : auditRepository.findAll()) {
            auditCreateService.log(failedAudit);
            auditRepository.delete(failedAudit);
        }
    }
}
