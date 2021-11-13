package com.dis.audit.service.mapper;

import com.dis.audit.common.model.database.FailedAudit;
import com.dis.audit.common.model.database.FailedMessageProperties;
import com.dis.audit.common.model.messaging.AuditMessage;
import com.dis.audit.common.model.messaging.AuditOperation;
import com.dis.audit.common.model.messaging.AuditProperties;
import com.dis.audit.controller.create.dto.AuditCreateRequest;
import com.dis.audit.model.audit.Audit;
import com.dis.audit.model.audit.Properties;
import com.dis.audit.model.site.SiteConfiguration;
import com.dis.audit.repository.SiteConfigurationRepository;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AuditCreateMapper {

    private final SiteConfigurationRepository siteConfigurationRepository;

    public AuditCreateMapper(SiteConfigurationRepository siteConfigurationRepository) {
        this.siteConfigurationRepository = siteConfigurationRepository;
    }

    public Audit mapAuditCreateRequestToAudit(AuditCreateRequest auditCreateRequest) throws ParseException {
        return getEntity(
                auditCreateRequest.getSiteCode(),
                auditCreateRequest.getUserName(),
                auditCreateRequest.getDate(),
                auditCreateRequest.getOriginator(),
                auditCreateRequest.getOriginatorId(),
                auditCreateRequest.getOperation(),
                auditCreateRequest.getProperties()
        );
    }

    public Audit mapAuditConsumerToAudit(AuditMessage auditMessage) throws ParseException {
        return getEntity(
                auditMessage.getSiteCode(),
                auditMessage.getUserName(),
                auditMessage.getDate(),
                auditMessage.getOriginator(),
                auditMessage.getOriginatorId(),
                auditMessage.getAuditOperation(),
                auditMessage.getProperties()
        );
    }

    public Audit mapFailedAuditToAudit(FailedAudit failedAudit) throws ParseException {
        return getEntity(
                failedAudit.getSiteCode(),
                failedAudit.getUserName(),
                failedAudit.getDate(),
                failedAudit.getOriginator(),
                failedAudit.getOriginatorId(),
                AuditOperation.valueOf(failedAudit.getAuditOperation()),
                getFailedAuditProperties(failedAudit.getProperties())
        );
    }

    private List<AuditProperties> getFailedAuditProperties(List<FailedMessageProperties> properties) {
        return properties.stream().map(failedMessageProperties -> new AuditProperties(
                failedMessageProperties.getPropertyName(),
                failedMessageProperties.getNewValue(),
                failedMessageProperties.getOldValue()
        )).collect(Collectors.toList());
    }

    private Audit getEntity(String siteCode,
                            String userName,
                            String modifiedDate,
                            String originator,
                            String originatorId,
                            AuditOperation operation,
                            List<AuditProperties> properties) {

        Optional<SiteConfiguration> siteConfigurationOptional =
                siteConfigurationRepository.getSiteConfigurationBySiteCode(siteCode);

        LocalDateTime original =
                LocalDateTime.parse(modifiedDate, DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy"));

        SiteConfiguration siteConfiguration = new SiteConfiguration();
        if (siteConfigurationOptional.isPresent())
            siteConfiguration = siteConfigurationOptional.get();


        ZoneId zoneId = ZoneId.of(siteConfiguration.getTimeZone());

        String formatDate =
                ZonedDateTime.of(original, zoneId).format(DateTimeFormatter.ofPattern(siteConfiguration.getDateFormat()));

        if (CollectionUtils.isEmpty(properties))
            return new Audit(
                    siteCode,
                    userName,
                    operation.toString(),
                    formatDate,
                    originator,
                    originatorId
            );

        return new Audit(
                siteCode,
                userName,
                operation.toString(),
                formatDate,
                originator,
                originatorId,
                getEntityProperties(properties)
        );
    }

    private List<Properties> getEntityProperties(List<AuditProperties> properties) {

        List<Properties> auditProperties = new ArrayList<>();
        for (AuditProperties property : properties) {
            handleSingleProperty(auditProperties, property);
        }

        return auditProperties;
    }

    private void handleSingleProperty(List<Properties> auditProperties, AuditProperties property) {
        auditProperties.add(new Properties(
                property.getPropertyName(),
                property.getOldValue(),
                property.getNewValue()));
    }


}

