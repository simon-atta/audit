package com.dis.audit.service.create;

import com.dis.audit.common.model.database.FailedAudit;
import com.dis.audit.common.model.messaging.AuditMessage;
import com.dis.audit.controller.create.dto.AuditCreateRequest;
import com.dis.audit.model.audit.Audit;
import com.dis.audit.repository.IAuditRepository;
import com.dis.audit.service.mapper.AuditCreateMapper;
import com.dis.exception.handler.excpetion.DateTimeParseException;
import org.springframework.stereotype.Service;

import java.text.ParseException;


@Service
public class AuditCreateService implements IAuditCreateService {

    private final AuditCreateMapper auditCreateMapper;
    private final IAuditRepository auditRepository;

    public AuditCreateService(AuditCreateMapper auditCreateMapper,
                              IAuditRepository auditRepository) {
        this.auditCreateMapper = auditCreateMapper;
        this.auditRepository = auditRepository;
    }

    @Override
    public Audit log(AuditCreateRequest auditCreateRequest) {
        try {
            Audit audit = auditCreateMapper.mapAuditCreateRequestToAudit(auditCreateRequest);
            auditRepository.save(audit);
            return audit;
        } catch (ParseException exception) {
            throw DateTimeParseException.build("dateParse.exception");
        }
    }

    @Override
    public void log(AuditMessage auditMessage) {
        try {
            auditRepository.save(auditCreateMapper.mapAuditConsumerToAudit(auditMessage));
        } catch (ParseException exception) {
            throw DateTimeParseException.build("dateParse.exception");
        }
    }

    @Override
    public void log(FailedAudit failedAudit) {
        try {
            auditRepository.save(auditCreateMapper.mapFailedAuditToAudit(failedAudit));
        } catch (ParseException exception) {
            throw DateTimeParseException.build("dateParse.exception");
        }
    }


}