package com.jc.hprest.hpdemo.dao;

import com.jc.hprest.hpdemo.entity.services.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
}
