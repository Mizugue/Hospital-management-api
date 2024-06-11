package com.jc.hprest.hpdemo.rest;

import com.jc.hprest.hpdemo.entity.Patient;
import com.jc.hprest.hpdemo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class PatientRestController {


    private PatientService patientService;

    @Autowired
    public PatientRestController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public List<Patient> findAll(){
        return patientService.findAll();
    }


}
