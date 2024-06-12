package com.jc.hprest.hpdemo.dao;


import com.jc.hprest.hpdemo.entity.services.Hospitalization;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HospitalizationRepository extends JpaRepository<Hospitalization, Integer> {
}