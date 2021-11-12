package com.avicss.audit.service.search;

import com.avicss.audit.controller.search.dto.request.AuditSearchCriteria;
import com.avicss.audit.controller.search.dto.response.AuditSearchResponse;

import java.util.List;

public interface IAuditSearchService {

    List<AuditSearchResponse> searchForAudit(AuditSearchCriteria auditSearchCriteria);

}
