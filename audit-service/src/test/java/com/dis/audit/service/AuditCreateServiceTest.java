package com.dis.audit.service;

import com.dis.audit.model.audit.Audit;
import com.dis.audit.repository.IAuditRepository;
import com.dis.audit.repository.SiteConfigurationRepository;
import com.dis.audit.service.create.IAuditCreateService;
import com.dis.audit.util.DataUtil;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AuditCreateServiceTest{

    @Autowired
    private IAuditRepository auditRepository;

    @Autowired
    private IAuditCreateService auditService;

    @MockBean
    private SiteConfigurationRepository siteConfigurationRepository;

    @Test
    public void test_createAudit() {
        when(siteConfigurationRepository.getSiteConfigurationBySiteCode(any())).thenReturn(
                DataUtil.getSiteConfiguration()
        );

        auditService.log(DataUtil.createAuditCreateRequestWithProperties());
        List<Audit> audits = auditRepository.findAll();
        assertFalse(audits.isEmpty());
    }




}
