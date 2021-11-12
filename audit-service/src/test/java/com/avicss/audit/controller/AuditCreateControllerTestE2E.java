package com.avicss.audit.controller;

import com.avicss.audit.util.DataUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AuditCreateControllerTestE2E extends AbstractTest {

    @Test
    public void test_logAudit() throws Exception {

        String inputJson = super.mapToJson(DataUtil.getAuditCreateRequest());
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/audit/v1/create")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
    }
}
