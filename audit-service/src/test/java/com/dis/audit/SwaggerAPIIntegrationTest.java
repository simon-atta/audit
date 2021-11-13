package com.dis.audit;

import com.dis.audit.common.repo.AuditRepository;
import com.dis.audit.configuration.SwaggerConfiguration;
import com.dis.audit.repository.IAuditRepository;
import com.dis.audit.repository.SiteConfigurationRepository;
import com.dis.audit.service.create.IAuditCreateService;
import com.dis.audit.service.failed.IAuditFailedMessage;
import com.dis.audit.service.mapper.AuditCreateMapper;
import com.dis.audit.service.mapper.AuditRetrieveMapper;
import com.dis.audit.service.search.IAuditSearchService;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.FileWriter;
import java.io.Writer;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@Import(SwaggerConfiguration.class)
public class SwaggerAPIIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IAuditCreateService userRepository;

    @MockBean
    private IAuditRepository auditRepository;

    @MockBean
    private IAuditSearchService userRetrieveService;

    @MockBean
    private AuditRetrieveMapper auditRetrieveMapper;

    @MockBean
    private AuditCreateMapper auditCreateMapper;

    @MockBean
    private SiteConfigurationRepository configurationRepository;

    @MockBean
    private AuditRepository jpaAuditRepository;

    @MockBean
    private IAuditFailedMessage auditFailedMessage;

    @Test
    public void swaggerJsonExists() throws Exception {
        String contentAsString = mockMvc
                .perform(MockMvcRequestBuilders.get("/v2/api-docs")
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andReturn()
                .getResponse().getContentAsString();
        try (Writer writer = new FileWriter("build/swagger.json")) {
            IOUtils.write(contentAsString, writer);
        }
    }
}
