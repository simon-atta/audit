package com.dis.audit.model.audit;

import lombok.Getter;

import java.util.List;

@Getter
public class Properties {

    private String propertyName;

    private String oldValue;

    private String newValue;

    private List<String> oldValues;

    private List<String> newValues;

    public Properties() {
    }

    public Properties(String propertyName, String oldValue, String newValue) {
        this.propertyName = propertyName;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public Properties(String propertyName, List<String> oldValues, List<String> newValues) {
        this.propertyName = propertyName;
        this.oldValues = oldValues;
        this.newValues = newValues;
    }
}
