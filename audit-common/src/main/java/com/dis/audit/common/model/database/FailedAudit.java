package com.dis.audit.common.model.database;

import com.dis.audit.common.model.messaging.AuditMessage;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
public class FailedAudit {

    @Id
    @GeneratedValue
    private long id;

    private String siteCode;

    private String userName;

    private String date;

    private String originator;

    private String originatorId;

    private String auditOperation;

    @OneToMany(cascade = CascadeType.ALL)
    private List<FailedMessageProperties> properties;

    public FailedAudit() {
    }

    public FailedAudit(AuditMessage auditMessage) {
        this.siteCode = auditMessage.getSiteCode();
        this.userName = auditMessage.getUserName();
        this.date = auditMessage.getDate();
        this.originator = auditMessage.getOriginator();
        this.originatorId = auditMessage.getOriginatorId();
        this.auditOperation = auditMessage.getAuditOperation().toString();
    }
}
