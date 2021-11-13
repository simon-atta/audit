package com.dis.audit.controller.search.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AuditSearchCriteria {

    private String siteCode;

    private String userName;

    private String propertyName;

    private Date modifiedDate;

    private String originator;

    private String originatorId;

}
