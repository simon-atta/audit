package com.avicss.audit.controller.failed;

import com.avicss.audit.controller.search.dto.response.AuditSearchResponse;
import com.avicss.exception.handler.model.ApiError;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static com.avicss.audit.constants.AuditAPIConstants.*;


@Api(value = AUDIT_API, tags = {AUDIT_API_TAG})
public interface AuditFailedApi {

    @ApiOperation(value = FAILED_AUDIT_VALUE, nickname = FAILED_AUDIT_NICKNAME, notes = FAILED_AUDIT_NOTES,
            response = ApiError.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = SUCCESSFUL_OPERATION, response = AuditSearchResponse.class),
            @ApiResponse(code = 400, message = BAD_REQUEST, response = ApiError.class)})
    @PostMapping(value = "/audit/v1/failed/sync", produces = {APPLICATION_JSON})
    ResponseEntity<List<AuditSearchResponse>> sync();

}
