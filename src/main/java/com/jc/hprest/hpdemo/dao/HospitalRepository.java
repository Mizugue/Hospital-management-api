package com.jc.hprest.hpdemo.dao;


import com.jc.hprest.hpdemo.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
}
