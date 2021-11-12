package com.avicss.audit;

import com.avicss.exception.handler.EnableAutoExceptionAndValidationHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@EnableFeignClients
@EnableEurekaClient
@EnableAutoExceptionAndValidationHandler
@EnableFailedAuditHandler
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
