package com.dis.audit.service.search;

import com.dis.audit.controller.search.dto.request.AuditSearchCriteria;
import com.dis.audit.controller.search.dto.response.AuditSearchResponse;

import java.util.List;

public interface IAuditSearchService {

    List<AuditSearchResponse> searchForAudit(AuditSearchCriteria auditSearchCriteria);

}
