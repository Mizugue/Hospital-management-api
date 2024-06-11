package com.jc.hprest.hpdemo.serviceimpl;

import com.jc.hprest.hpdemo.dao.PatientDAO;
import com.jc.hprest.hpdemo.entity.Patient;
import com.jc.hprest.hpdemo.service.PatientService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientServiceimpl implements PatientService {

    private PatientDAO patientDAO;


    @Autowired
    public PatientServiceimpl(PatientDAO patientDAO){
        this.patientDAO = patientDAO;
    }

    @Override
    public List<Patient> findAll() {
        return patientDAO.findAll();
    }

    @Override
    public Patient findById(int id) {
       return patientDAO.findById(id);
    }

    @Transactional
    @Override
    public Patient save(Patient patient) {
        return patientDAO.save(patient);
    }

    @Transactional
    @Override
    public Patient deleteById(int id) {
        return patientDAO.deleteById(id);
    }


}
