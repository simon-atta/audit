package com.dis.audit.service;

import com.dis.audit.controller.search.dto.request.AuditSearchCriteria;
import com.dis.audit.controller.search.dto.response.AuditSearchResponse;
import com.dis.audit.repository.IAuditRepository;
import com.dis.audit.repository.SiteConfigurationRepository;
import com.dis.audit.service.create.IAuditCreateService;
import com.dis.audit.service.search.IAuditSearchService;
import com.dis.audit.util.DataUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AuditSearchServiceTest {

    @Autowired
    private IAuditRepository auditRepository;

    @Autowired
    private IAuditCreateService auditCreateService;

    @Autowired
    private IAuditSearchService auditSearchService;

    @MockBean
    private SiteConfigurationRepository siteConfigurationRepository;

    @Test
    public void test_auditSearch() {
        when(siteConfigurationRepository.getSiteConfigurationBySiteCode(any())).thenReturn(
                DataUtil.getSiteConfiguration()
        );

        auditCreateService.log(DataUtil.getAuditCreateRequestWithPropertiesSearch());

        AuditSearchCriteria auditSearchCriteria = new AuditSearchCriteria();
        auditSearchCriteria.setUserName("sigho2");

        List<AuditSearchResponse> auditSearchResponses =
                auditSearchService.searchForAudit(auditSearchCriteria);
        assertEquals(auditSearchResponses.size(), 1);
    }

}
