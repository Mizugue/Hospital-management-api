package com.jc.hprest.hpdemo.dao;


import com.jc.hprest.hpdemo.entity.services.LocalService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "localservices")
public interface LocalServiceRepository extends JpaRepository<LocalService, Integer> {
}
