package com.openpay.marvel.api.rest.service.impl;

import com.openpay.marvel.api.rest.model.entity.RequestLogEntity;
import com.openpay.marvel.api.rest.repository.RequestLogRepository;
import com.openpay.marvel.api.rest.service.RequestLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestLogServiceImpl implements RequestLogService {

    private final RequestLogRepository requestLogRepository;

    @Autowired
    public RequestLogServiceImpl(RequestLogRepository requestLogRepository) {
        this.requestLogRepository = requestLogRepository;
    }

    @Override
    public List<RequestLogEntity> getAllRequestLogs() {
        return requestLogRepository.findAll();
    }
}