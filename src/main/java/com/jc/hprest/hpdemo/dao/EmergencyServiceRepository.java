package com.jc.hprest.hpdemo.dao;

import com.jc.hprest.hpdemo.entity.services.EmergencyService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "emergencies")
public interface EmergencyServiceRepository extends JpaRepository<EmergencyService, Integer> {
}
