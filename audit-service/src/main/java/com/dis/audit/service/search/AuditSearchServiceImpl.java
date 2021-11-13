package com.dis.audit.service.search;

import com.dis.audit.controller.search.dto.request.AuditSearchCriteria;
import com.dis.audit.controller.search.dto.response.AuditSearchResponse;
import com.dis.audit.model.audit.Audit;
import com.dis.audit.service.mapper.AuditRetrieveMapper;
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
