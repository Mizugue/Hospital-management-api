package com.jc.hprest.hpdemo.service;

import com.jc.hprest.hpdemo.entity.triad.Hospital;

import java.util.List;

public interface HospitalService {

    List<Hospital> findAll();

    Hospital findById(int id);

    Hospital save(Hospital hospital);

    Hospital deleteById(int id);

}




