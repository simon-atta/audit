package com.avicss.audit.service.search;

import com.avicss.audit.controller.search.dto.request.AuditSearchCriteria;
import com.avicss.audit.controller.search.dto.response.AuditSearchResponse;
import com.avicss.audit.model.audit.Audit;
import com.avicss.audit.service.mapper.AuditRetrieveMapper;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditSearchServiceImpl implements IAuditSearchService {

    private final MongoTemplate mongoTemplate;

    private final AuditRetrieveMapper auditRetrieveMapper;

    public AuditSearchServiceImpl(MongoTemplate mongoTemplate, AuditRetrieveMapper auditRetrieveMapper) {
        this.mongoTemplate = mongoTemplate;
        this.auditRetrieveMapper = auditRetrieveMapper;
    }

    @Override
    public List<AuditSearchResponse> searchForAudit(AuditSearchCriteria auditSearchCriteria) {
        List<Audit> userSearchList
                = mongoTemplate.find(QueryBuilder.build(auditSearchCriteria), Audit.class);

        return auditRetrieveMapper.fromEntityList(userSearchList);
    }


}
