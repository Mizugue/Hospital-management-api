package com.jc.hprest.hpdemo.dao;

import com.jc.hprest.hpdemo.entity.triad.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
