package com.jc.hprest.hpdemo.dao;

import com.jc.hprest.hpdemo.entity.Patient;

import java.util.List;

public interface PatientDAO {

    List<Patient> findAll();

    Patient findById(int id);

    Patient save(Patient patient);

    Patient deleteById(int id);
}
