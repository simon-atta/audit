package com.avicss.audit.controller;

import com.avicss.audit.controller.search.dto.request.AuditSearchCriteria;
import com.avicss.audit.service.create.IAuditCreateService;
import com.avicss.audit.util.DataUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AuditSearchControllerTestE2E extends AbstractTest {

    @Autowired
    private IAuditCreateService auditCreateService;

    @Test
    public void test_logAudit() throws Exception {
        auditCreateService.log(DataUtil.getAuditCreateRequest());

        AuditSearchCriteria auditSearchCriteria = new AuditSearchCriteria();
        auditSearchCriteria.setUserName("sigho1");

        String inputJson = super.mapToJson(auditSearchCriteria);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/audit/v1/search")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

//        ObjectMapper mapper = new ObjectMapper();
//
//        List<AuditSearchResponse> actual = mapper.readValue(mvcResult.getResponse().getContentAsString(),
//                new TypeReference<List<AuditSearchResponse>>() {});
//
//        assertEquals(actual.size(), 1);
    }


}
