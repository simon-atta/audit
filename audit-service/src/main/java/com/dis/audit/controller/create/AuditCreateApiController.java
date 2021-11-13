package com.dis.audit.controller.create;

import com.dis.audit.controller.create.dto.AuditCreateRequest;
import com.dis.audit.controller.search.dto.response.AuditSearchResponse;
import com.dis.audit.service.create.IAuditCreateService;
import com.dis.audit.service.mapper.AuditRetrieveMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuditCreateApiController implements AuditCreateApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuditCreateApiController.class);

    private final IAuditCreateService auditService;
    private final AuditRetrieveMapper auditRetrieveMapper;

    public AuditCreateApiController(IAuditCreateService auditService,
                                    AuditRetrieveMapper auditRetrieveMapper) {
        this.auditService = auditService;
        this.auditRetrieveMapper = auditRetrieveMapper;
    }

    @Override
    public ResponseEntity<AuditSearchResponse> auditCreate(AuditCreateRequest auditCreateRequest) {
        LOGGER.debug("Start method audit auditCreate()");
        return new ResponseEntity<>(
                auditRetrieveMapper.fromEntity(auditService.log(auditCreateRequest)),
                HttpStatus.CREATED
        );
    }
}
