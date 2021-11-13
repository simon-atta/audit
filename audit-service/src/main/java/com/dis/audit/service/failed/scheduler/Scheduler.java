package com.dis.audit.service.failed.scheduler;

import com.dis.audit.service.failed.IAuditFailedMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class Scheduler {

    private final IAuditFailedMessage auditFailedMessage;

    public Scheduler(IAuditFailedMessage auditFailedMessage) {
        this.auditFailedMessage = auditFailedMessage;
    }

    @Scheduled(cron = "* * 23 * * *")
    public void trackOverduePayments() {
        auditFailedMessage.syncFailedAuditMessage();
    }


}
