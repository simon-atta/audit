package com.avicss.audit.service.search;

import com.avicss.audit.controller.search.dto.request.AuditSearchCriteria;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


class QueryBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueryBuilder.class);

    private QueryBuilder() {
    }

    static Query build(AuditSearchCriteria auditSearchCriteria) {

        Query query = new Query();

        if (!Strings.isNullOrEmpty(auditSearchCriteria.getPropertyName()))
            query.addCriteria(Criteria.where("propertyName").is(auditSearchCriteria.getPropertyName()));

        if (!Strings.isNullOrEmpty(auditSearchCriteria.getOriginator()))
            query.addCriteria(Criteria.where("originator").is(auditSearchCriteria.getOriginator()));

        if (!Strings.isNullOrEmpty(auditSearchCriteria.getOriginatorId()))
            query.addCriteria(Criteria.where("originatorId").is(auditSearchCriteria.getOriginatorId()));

        if (!Strings.isNullOrEmpty(auditSearchCriteria.getUserName()))
            query.addCriteria(Criteria.where("userName").is(auditSearchCriteria.getUserName()));

        if (auditSearchCriteria.getModifiedDate() != null)
            query.addCriteria(Criteria.where("modifiedDate").is(auditSearchCriteria.getModifiedDate()));

        return query;
    }


}
