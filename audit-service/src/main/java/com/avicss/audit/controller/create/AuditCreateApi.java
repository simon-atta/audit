package com.avicss.audit.controller.create;

import com.avicss.audit.controller.create.dto.AuditCreateRequest;
import com.avicss.audit.controller.search.dto.response.AuditSearchResponse;
import com.avicss.exception.handler.model.ApiError;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

import static com.avicss.audit.constants.AuditAPIConstants.*;


@Api(value = AUDIT_API, tags = {AUDIT_API_TAG})
@Validated
public interface AuditCreateApi {

    @ApiOperation(value = CREATE_AUDIT_VALUE, nickname = CREATE_AUDIT_NICKNAME, notes = CREATE_AUDIT_NOTES,
            response = AuditSearchResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = SUCCESSFUL_OPERATION, response = AuditSearchResponse.class),
            @ApiResponse(code = 400, message = BAD_REQUEST, response = ApiError.class)})
    @PostMapping(value = "/audit/v1/create", produces = {APPLICATION_JSON})
    ResponseEntity<AuditSearchResponse> auditCreate(
            @Valid @RequestBody AuditCreateRequest auditCreateRequest
    );


}
