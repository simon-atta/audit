package com.dis.audit.common.mapper;

import com.dis.audit.common.model.database.FailedAudit;
import com.dis.audit.common.model.database.FailedMessageProperties;
import com.dis.audit.common.model.messaging.AuditMessage;
import com.dis.audit.common.model.messaging.AuditProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class AuditMapper {

    private AuditMapper() {
    }

    public static AuditMessage mapAudit(String userName,
                                        String date,
                                        String originator,
                                        String originatorId,
                                        String siteCode) {

        return new AuditMessage(
                userName,
                date,
                originator,
                originatorId,
                siteCode
        );
    }


    public static FailedAudit mapFailedAudit(AuditMessage auditMessage) {
        FailedAudit failedAudit = new FailedAudit(auditMessage);
        if (!CollectionUtils.isEmpty(auditMessage.getProperties()))
            failedAudit.setProperties(getFailedUpdateProperties(auditMessage.getProperties()));

        return failedAudit;
    }

    private static List<FailedMessageProperties> getFailedUpdateProperties(List<AuditProperties> properties) {
        return properties.stream().map(auditProperties ->
                new FailedMessageProperties(auditProperties.getPropertyName(),
                        auditProperties.getOldValue(), auditProperties.getNewValue())).collect(Collectors.toList());
    }


}
