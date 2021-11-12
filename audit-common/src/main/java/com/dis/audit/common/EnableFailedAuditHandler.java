package com.dis.audit.common;

import com.dis.audit.common.configuration.AuditConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(AuditConfiguration.class)
public @interface EnableFailedAuditHandler {
}
