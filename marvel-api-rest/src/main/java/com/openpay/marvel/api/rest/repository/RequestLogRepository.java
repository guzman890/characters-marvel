package com.openpay.marvel.api.rest.repository;


import com.openpay.marvel.api.rest.model.entity.RequestLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestLogRepository extends JpaRepository<RequestLogEntity, Long> {
}