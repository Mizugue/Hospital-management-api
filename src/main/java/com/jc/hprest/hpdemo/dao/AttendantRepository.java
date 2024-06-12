package com.jc.hprest.hpdemo.dao;

import com.jc.hprest.hpdemo.entity.thirdparty.Attendant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendantRepository extends JpaRepository<Attendant, Integer> {
}
