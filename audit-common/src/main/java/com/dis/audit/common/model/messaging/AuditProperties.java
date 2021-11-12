package com.dis.audit.common.model.messaging;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuditProperties {

    // Audit
    private String propertyName;

    private String oldValue;

    private String newValue;

    public AuditProperties() {
    }

    public AuditProperties(String propertyName, String oldValue, String newValue) {
        this.propertyName = propertyName;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

}
