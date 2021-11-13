package com.dis.audit.controller.failed;

import com.dis.audit.controller.search.dto.response.AuditSearchResponse;
import com.dis.audit.constants.AuditAPIConstants;
import com.dis.exception.handler.model.ApiError;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Api(value = AuditAPIConstants.AUDIT_API, tags = {AuditAPIConstants.AUDIT_API_TAG})
public interface AuditFailedApi {

    @ApiOperation(value = AuditAPIConstants.FAILED_AUDIT_VALUE,
            nickname = AuditAPIConstants.FAILED_AUDIT_NICKNAME,
            notes = AuditAPIConstants.FAILED_AUDIT_NOTES,
            response = ApiError.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = AuditAPIConstants.SUCCESSFUL_OPERATION, response = AuditSearchResponse.class),
            @ApiResponse(code = 400, message = AuditAPIConstants.BAD_REQUEST, response = ApiError.class)})
    @PostMapping(value = "/audit/v1/failed/sync", produces = {AuditAPIConstants.APPLICATION_JSON})
    ResponseEntity<List<AuditSearchResponse>> sync();

}
