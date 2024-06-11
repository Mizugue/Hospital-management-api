package com.jc.hprest.hpdemo.dao;

import com.jc.hprest.hpdemo.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
