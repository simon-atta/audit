package com.dis.audit.controller.failed;

import com.dis.audit.controller.search.dto.response.AuditSearchResponse;
import com.dis.audit.service.failed.IAuditFailedMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuditFailedApiImpl implements AuditFailedApi {

    private final IAuditFailedMessage auditFailedMessage;

    public AuditFailedApiImpl(IAuditFailedMessage auditFailedMessage) {
        this.auditFailedMessage = auditFailedMessage;
    }

    @Override
    public ResponseEntity<List<AuditSearchResponse>> sync() {
        auditFailedMessage.syncFailedAuditMessage();

        return null;
    }
}
