package com.avicss.audit.util;


import com.avicss.audit.controller.create.dto.AuditCreateRequest;
import com.avicss.audit.model.messaging.AuditOperation;
import com.avicss.audit.model.messaging.AuditProperties;
import com.avicss.audit.model.site.SiteConfiguration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class DataUtil {

    public static Optional<SiteConfiguration> getSiteConfiguration() {
        SiteConfiguration siteConfiguration = new SiteConfiguration();
        siteConfiguration.setSiteCode("CAI");
        siteConfiguration.setDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
        siteConfiguration.setTimeZone("Africa/Cairo");
        return Optional.of(siteConfiguration);
    }

    public static AuditCreateRequest getAuditCreateRequest() {
        AuditCreateRequest auditCreateRequest = new AuditCreateRequest();
        auditCreateRequest.setUserName("sigho1");
        auditCreateRequest.setOriginatorId("158975784524");
        auditCreateRequest.setOriginator("user-service");
        auditCreateRequest.setOperation(AuditOperation.CREATE);
        auditCreateRequest.setDate(new Date().toString());
        auditCreateRequest.setSiteCode("CAI");
        return auditCreateRequest;
    }

    public static AuditCreateRequest createAuditCreateRequestWithProperties() {
        AuditCreateRequest auditCreateRequest = new AuditCreateRequest();

        auditCreateRequest.setOriginator("user-service");
        auditCreateRequest.setOriginatorId("1236545452121");
        auditCreateRequest.setDate(new Date().toString());
        auditCreateRequest.setUserName("sigho1");
        auditCreateRequest.setOperation(AuditOperation.CREATE);
        auditCreateRequest.setSiteCode("CAI");

        List<AuditProperties> properties = new ArrayList<>();
        AuditProperties properties1 = new AuditProperties(
                "name","newValue","oldValue"
        );
        properties.add(properties1);

        auditCreateRequest.setProperties(properties);
        return auditCreateRequest;
    }

    public static AuditCreateRequest getAuditCreateRequestWithPropertiesSearch() {
        AuditCreateRequest auditCreateRequest = new AuditCreateRequest();

        auditCreateRequest.setOriginator("user-service");
        auditCreateRequest.setOriginatorId("1236545452121");
        auditCreateRequest.setDate(new Date().toString());
        auditCreateRequest.setUserName("sigho2");
        auditCreateRequest.setOperation(AuditOperation.CREATE);
        auditCreateRequest.setSiteCode("CAI");

        List<AuditProperties> properties = new ArrayList<>();
        AuditProperties properties1 = new AuditProperties();
        properties1.setPropertyName("name");
        properties1.setNewValue("newValue");
        properties1.setOldValue("oldValue");
        properties.add(properties1);

        auditCreateRequest.setProperties(properties);


        return auditCreateRequest;
    }

}
