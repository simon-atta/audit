package com.avicss.audit.service.mapper;

import com.avicss.audit.controller.search.dto.response.AuditSearchProperties;
import com.avicss.audit.controller.search.dto.response.AuditSearchResponse;
import com.avicss.audit.model.audit.Audit;
import com.avicss.audit.model.audit.Properties;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuditRetrieveMapper {

    public List<AuditSearchResponse> fromEntityList(List<Audit> userSearchList) {

        return userSearchList.stream().map(
                this::getAuditSearchResponse
        ).collect(Collectors.toList());
    }

    private AuditSearchResponse getAuditSearchResponse(Audit audit) {
        return new AuditSearchResponse(
                audit.getId(),
                audit.getUserName(),
                audit.getDate(),
                audit.getOriginator(),
                audit.getOriginatorId(),
                audit.getOperation(),
                getProperties(audit.getProperties())
        );
    }

    public AuditSearchResponse fromEntity(Audit audit) {
        return new AuditSearchResponse(
                audit.getId(),
                audit.getUserName(),
                audit.getDate(),
                audit.getOriginator(),
                audit.getOriginatorId(),
                audit.getOperation(),
                getProperties(audit.getProperties())
        );
    }

    private List<AuditSearchProperties> getProperties(List<Properties> properties) {
        if (CollectionUtils.isEmpty(properties))
            return Collections.emptyList();

        return properties.stream().map(
                auditProperty -> new AuditSearchProperties(
                        auditProperty.getPropertyName(),
                        auditProperty.getOldValue(),
                        auditProperty.getNewValue()
                )
        ).collect(Collectors.toList());
    }
}
