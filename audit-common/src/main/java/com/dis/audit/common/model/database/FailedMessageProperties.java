package com.dis.audit.common.model.database;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class FailedMessageProperties {

    @Id
    @GeneratedValue
    private long id;

    // Audit
    private String propertyName;

    private String oldValue;

    private String newValue;

    public FailedMessageProperties() {
    }

    public FailedMessageProperties(String propertyName, String oldValue, String newValue) {
        this.propertyName = propertyName;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

}
