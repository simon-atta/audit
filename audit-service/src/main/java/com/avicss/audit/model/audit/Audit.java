package com.avicss.audit.model.audit;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import java.util.List;

@Document
@Getter
@Setter
@Valid
public class Audit {

    @Id
    private String id;

    private String siteCode;

    private String userName;

    private String date;

    private String originator;

    private String originatorId;

    private String operation;

    private List<Properties> properties;

    public Audit() {
    }

    public Audit(String siteCode,
                 String userName,
                 String operation,
                 String date,
                 String originator,
                 String originatorId) {
        this.siteCode = siteCode;
        this.userName = userName;
        this.date = date;
        this.originator = originator;
        this.originatorId = originatorId;
        this.operation = operation;
    }

    public Audit(String siteCode,
                 String userName,
                 String operation,
                 String date,
                 String originator,
                 String originatorId,
                 List<Properties> properties) {
        this.siteCode = siteCode;
        this.userName = userName;
        this.date = date;
        this.originator = originator;
        this.originatorId = originatorId;
        this.properties = properties;
        this.operation = operation;
    }
}
