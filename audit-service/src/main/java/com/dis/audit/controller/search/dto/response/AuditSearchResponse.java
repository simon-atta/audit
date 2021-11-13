package com.dis.audit.controller.search.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import de.otto.edison.hal.HalRepresentation;
import de.otto.edison.hal.Links;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuditSearchResponse extends HalRepresentation {

    private String id;

    private String userName;

    private String date;

    private String originator;

    private String originatorId;

    private String operation;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<AuditSearchProperties> properties;

    public AuditSearchResponse() {
    }

    public AuditSearchResponse(String id,
                               String userName,
                               String date,
                               String originator,
                               String originatorId,
                               String operation,
                               List<AuditSearchProperties> properties) {
        this.id = id;
        this.userName = userName;
        this.date = date;
        this.originator = originator;
        this.originatorId = originatorId;
        this.operation = operation;
        this.properties = properties;
    }

    @Override
    public HalRepresentation add(final Links links) {
        return super.add(links);
    }
}
