package com.avicss.audit.controller.search;

import com.avicss.audit.controller.search.dto.request.AuditSearchCriteria;
import com.avicss.audit.controller.search.dto.response.AuditSearchResponse;
import com.avicss.audit.service.search.IAuditSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
public class AuditSearchApiController implements AuditSearchApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuditSearchApiController.class);


    @Autowired
    private IAuditSearchService auditSearchService;

    @Override
    public ResponseEntity<List<AuditSearchResponse>> auditSearch(AuditSearchCriteria auditSearchCriteria) {
        LOGGER.debug("Start method auditSearch()");
        return new ResponseEntity<>(
                auditSearchService.searchForAudit(auditSearchCriteria),
                HttpStatus.OK);
    }


}
