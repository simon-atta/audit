package com.dis.audit.controller.search.dto.response;

import lombok.Getter;

@Getter
public class AuditSearchProperties {

    // Audit
    private String propertyName;

    private String oldValue;

    private String newValue;

    public AuditSearchProperties(String propertyName, String oldValue, String newValue) {
        this.propertyName = propertyName;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }
}
