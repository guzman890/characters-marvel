package com.openpay.marvel.api.rest.aspect;

import com.openpay.marvel.api.rest.model.entity.RequestLogEntity;
import com.openpay.marvel.api.rest.repository.RequestLogRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private final RequestLogRepository requestLogRepository;

    @Autowired
    public LoggingAspect(RequestLogRepository requestLogRepository) {
        this.requestLogRepository = requestLogRepository;
    }

    @AfterReturning("execution(* com.openpay.marvel.api.rest.controller.CharacterController.*(..))")
    public void logRequest(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getMethod().getName();
        String endpoint = signature.getDeclaringTypeName() + "." + methodName;
        String requestDetails = Arrays.toString(joinPoint.getArgs());

        RequestLogEntity log = new RequestLogEntity();
        log.setTimestamp(LocalDateTime.now());
        log.setRequestType("CharacterController request");
        log.setEndpoint(endpoint);
        log.setRequestDetails(requestDetails);
        requestLogRepository.save(log);
    }
}