package com.avicss.audit.controller.create.dto;

import com.avicss.audit.model.messaging.AuditOperation;
import com.avicss.audit.model.messaging.AuditProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class AuditCreateRequest {

    @JsonProperty("siteCode")
    @NotBlank(message = "site_code.NotBlank")
    @NotEmpty(message = "site_code.NotEmpty")
    private String siteCode;

    @JsonProperty("userName")
    @NotBlank(message = "user_name.NotBlank")
    @NotEmpty(message = "user_name.NotEmpty")
    private String userName;

    @JsonProperty("date")
    @NotBlank(message = "date.NotBlank")
    @NotEmpty(message = "date.NotEmpty")
    private String date;

    @JsonProperty("originator")
    @NotBlank(message = "originator.NotBlank")
    @NotEmpty(message = "originator.NotEmpty")
    private String originator;

    @JsonProperty("originatorId")
    @NotBlank(message = "originator_id.NotBlank")
    @NotEmpty(message = "originator_id.NotEmpty")
    private String originatorId;

    @JsonProperty("operation")
    @NotNull(message = "operation.NotNull")
    private AuditOperation operation;

    private List<AuditProperties> properties;


}
