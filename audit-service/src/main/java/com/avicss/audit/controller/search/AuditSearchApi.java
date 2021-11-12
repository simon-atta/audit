package com.avicss.audit.controller.search;

import com.avicss.audit.controller.search.dto.request.AuditSearchCriteria;
import com.avicss.audit.controller.search.dto.response.AuditSearchResponse;
import com.avicss.exception.handler.model.ApiError;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static com.avicss.audit.constants.AuditAPIConstants.*;


@Api(value = AUDIT_API, tags = {AUDIT_API_TAG})
public interface AuditSearchApi {

    @ApiOperation(value = SEARCH_AUDIT_VALUE, nickname = SEARCH_AUDIT_NICKNAME, notes = SEARCH_AUDIT_NOTES,
            response = ApiError.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = SUCCESSFUL_OPERATION, response = AuditSearchResponse.class),
            @ApiResponse(code = 400, message = BAD_REQUEST, response = ApiError.class)})
    @GetMapping(value = "/audit/v1/search", produces = {APPLICATION_JSON})
    ResponseEntity<List<AuditSearchResponse>> auditSearch(
            @ApiParam(value = "Search Criteria") AuditSearchCriteria auditSearchCriteria
    );

}
