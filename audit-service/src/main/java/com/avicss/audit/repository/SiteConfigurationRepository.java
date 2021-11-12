package com.avicss.audit.repository;


import com.avicss.audit.model.site.SiteConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "site-configuration-service")
public interface SiteConfigurationRepository {

    @GetMapping("/site/v1/code/{siteCode}")
    Optional<SiteConfiguration> getSiteConfigurationBySiteCode(
            @PathVariable(value = "siteCode") String siteCode
    );
}


