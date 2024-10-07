package com.openpay.marvel.api.rest.service;

import com.openpay.marvel.api.rest.model.entity.RequestLogEntity;

import java.util.List;

public interface RequestLogService {
    List<RequestLogEntity> getAllRequestLogs();
}