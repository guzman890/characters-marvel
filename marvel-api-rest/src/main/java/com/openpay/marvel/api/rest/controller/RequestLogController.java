package com.openpay.marvel.api.rest.controller;

import com.openpay.marvel.api.rest.model.entity.RequestLogEntity;
import com.openpay.marvel.api.rest.service.RequestLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/request-logs")
public class RequestLogController {

    private final RequestLogService requestLogService;

    @Autowired
    public RequestLogController(RequestLogService requestLogService) {
        this.requestLogService = requestLogService;
    }

    @GetMapping
    public List<RequestLogEntity> getAllRequestLogs() {
        return requestLogService.getAllRequestLogs();
    }
}