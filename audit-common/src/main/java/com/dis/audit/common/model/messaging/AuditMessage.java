package com.dis.audit.common.model.messaging;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuditMessage {

    private String siteCode;

    private String userName;

    private String date;

    private String originator;

    private String originatorId;

    private AuditOperation auditOperation;

    private List<AuditProperties> properties;

    public AuditMessage() {
    }

    public AuditMessage(String userName,
                        String date,
                        String originator,
                        String originatorId,
                        String siteCode) {
        this.userName = userName;
        this.date = date;
        this.originator = originator;
        this.originatorId = originatorId;
        this.siteCode = siteCode;
    }

    public AuditMessage(String userName,
                        String date,
                        String originator,
                        String originatorId,
                        String siteCode,
                        List<AuditProperties> properties) {
        this.userName = userName;
        this.date = date;
        this.originator = originator;
        this.originatorId = originatorId;
        this.siteCode = siteCode;
        this.properties = properties;
    }
}
