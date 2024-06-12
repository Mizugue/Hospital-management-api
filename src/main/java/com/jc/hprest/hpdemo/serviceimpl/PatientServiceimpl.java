package com.jc.hprest.hpdemo.serviceimpl;


import com.jc.hprest.hpdemo.dao.PatientRepository;
import com.jc.hprest.hpdemo.entity.triad.Patient;
import com.jc.hprest.hpdemo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceimpl implements PatientService {

    private PatientRepository patientRepository;


    @Autowired
    public PatientServiceimpl(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient findById(int id) {
        Optional<Patient> result = patientRepository.findById(id);
        Patient patient = null;

        if (result.isPresent()) {
            patient = result.get();
        } else {
            throw new RuntimeException("Didi not find patient id = " + id);
        }
        return patient;
    }


    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }


    @Override
    public Patient deleteById(int id) {
        Optional<Patient> result = patientRepository.findById(id);
        Patient patient = null;

        if (result.isPresent()) {
            patient = result.get();
            patientRepository.deleteById(id);
        } else {
            throw new RuntimeException("Didi not find patient id = " + id);
        }
        return patient;
    }




}
