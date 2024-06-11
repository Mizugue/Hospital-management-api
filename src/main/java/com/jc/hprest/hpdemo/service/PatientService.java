package com.jc.hprest.hpdemo.service;

import com.jc.hprest.hpdemo.entity.Patient;
import java.util.List;
import java.util.Optional;


public interface PatientService {

    List<Patient> findAll();

    Patient findById(int id);

    Patient save(Patient patient);

    Patient deleteById(int id);


}
