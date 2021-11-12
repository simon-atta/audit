package com.dis.audit.common.configuration;



import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableJpaRepositories("com.dis.audit.common.repo")
@EntityScan("com.dis.audit.common.model")
@EnableAsync
public class AuditConfiguration {
}
