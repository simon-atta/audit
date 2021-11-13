package com.dis.audit.consumer.listener;

import com.dis.audit.common.model.messaging.AuditMessage;
import com.dis.audit.service.create.IAuditCreateService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {

    @Autowired
    private IAuditCreateService auditCreateService;

    @RabbitListener(queues = "audit", containerFactory = "messageFactory")
    public void handleMessage(AuditMessage auditConsumer) {
        auditCreateService.log(auditConsumer);
    }
}
