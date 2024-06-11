package com.jc.hprest.hpdemo.service;

import com.jc.hprest.hpdemo.entity.Doctor;
import java.util.List;

public interface DoctorService {

    List<Doctor> findAll();

    Doctor findById(int id);

    Doctor save(Doctor doctor);

    Doctor deleteById(int id);

}
