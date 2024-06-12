package com.jc.hprest.hpdemo.dao;

import com.jc.hprest.hpdemo.entity.thirdparty.Ambulance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmbulanceRepository extends JpaRepository<Ambulance, Integer> {
}
