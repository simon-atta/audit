package com.avicss.audit.model.site;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SiteConfiguration {

    private String id;
    private String siteCode;
    private String countryCode;
    private String dateFormat;
    private String timeZone;
    private List<String> languages;
    private Integer purge;

}
