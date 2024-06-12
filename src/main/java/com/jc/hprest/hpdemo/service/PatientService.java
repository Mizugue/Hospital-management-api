package com.jc.hprest.hpdemo.service;

import com.jc.hprest.hpdemo.entity.triad.Patient;
import java.util.List;


public interface PatientService {

    List<Patient> findAll();

    Patient findById(int id);

    Patient save(Patient patient);

    Patient deleteById(int id);


}
