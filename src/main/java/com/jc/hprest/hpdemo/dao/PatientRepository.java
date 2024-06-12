package com.jc.hprest.hpdemo.dao;

import com.jc.hprest.hpdemo.entity.triad.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
