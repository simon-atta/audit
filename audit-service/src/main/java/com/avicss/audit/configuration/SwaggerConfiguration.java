package com.avicss.audit.configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collection;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration implements WebMvcConfigurer {

    @Bean
    Jackson2ObjectMapperBuilder objectMapperBuilder() {
        return new Jackson2ObjectMapperBuilder().serializationInclusion(JsonInclude.Include.NON_EMPTY)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .modulesToInstall(new JavaTimeModule());
    }

    @Bean
    Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .paths(Predicates.or(regex("/"), regex("/audit.*"))).build()
                .useDefaultResponseMessages(false).apiInfo(apiInfo())
                .ignoredParameterTypes(ignoredTypes());
    }

    private Class[] ignoredTypes() {
        return new Class[]{ResponseEntity.class, Collection.class};
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Audit API")
                .description("This is audit api")
                .version("1.0.0")
                .license("N/A").build();
    }

}
