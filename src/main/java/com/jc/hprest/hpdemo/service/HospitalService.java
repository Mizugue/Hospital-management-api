package com.jc.hprest.hpdemo.service;

import com.jc.hprest.hpdemo.entity.Hospital;

import java.util.List;
import java.util.Optional;

public interface HospitalService {

    List<Hospital> findAll();

    Hospital findById(int id);

    Hospital save(Hospital hospital);

    Hospital deleteById(int id);

}




