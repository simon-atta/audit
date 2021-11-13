package com.dis.audit.controller.search;

import com.dis.audit.controller.search.dto.request.AuditSearchCriteria;
import com.dis.audit.controller.search.dto.response.AuditSearchResponse;
import com.dis.audit.constants.AuditAPIConstants;
import com.dis.exception.handler.model.ApiError;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Api(value = AuditAPIConstants.AUDIT_API, tags = {AuditAPIConstants.AUDIT_API_TAG})
public interface AuditSearchApi {

    @ApiOperation(value = AuditAPIConstants.SEARCH_AUDIT_VALUE, nickname = AuditAPIConstants.SEARCH_AUDIT_NICKNAME, notes = AuditAPIConstants.SEARCH_AUDIT_NOTES,
            response = ApiError.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = AuditAPIConstants.SUCCESSFUL_OPERATION, response = AuditSearchResponse.class),
            @ApiResponse(code = 400, message = AuditAPIConstants.BAD_REQUEST, response = ApiError.class)})
    @GetMapping(value = "/audit/v1/search", produces = {AuditAPIConstants.APPLICATION_JSON})
    ResponseEntity<List<AuditSearchResponse>> auditSearch(
            @ApiParam(value = "Search Criteria") AuditSearchCriteria auditSearchCriteria
    );

}
