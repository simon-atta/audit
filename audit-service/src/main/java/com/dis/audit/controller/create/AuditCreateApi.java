package com.dis.audit.controller.create;

import com.dis.audit.controller.create.dto.AuditCreateRequest;
import com.dis.audit.controller.search.dto.response.AuditSearchResponse;
import com.dis.audit.constants.AuditAPIConstants;
import com.dis.exception.handler.model.ApiError;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;


@Api(value = AuditAPIConstants.AUDIT_API, tags = {AuditAPIConstants.AUDIT_API_TAG})
@Validated
public interface AuditCreateApi {

    @ApiOperation(value = AuditAPIConstants.CREATE_AUDIT_VALUE, nickname = AuditAPIConstants.CREATE_AUDIT_NICKNAME, notes = AuditAPIConstants.CREATE_AUDIT_NOTES,
            response = AuditSearchResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = AuditAPIConstants.SUCCESSFUL_OPERATION, response = AuditSearchResponse.class),
            @ApiResponse(code = 400, message = AuditAPIConstants.BAD_REQUEST, response = ApiError.class)})
    @PostMapping(value = "/audit/v1/create", produces = {AuditAPIConstants.APPLICATION_JSON})
    ResponseEntity<AuditSearchResponse> auditCreate(
            @Valid @RequestBody AuditCreateRequest auditCreateRequest
    );


}
