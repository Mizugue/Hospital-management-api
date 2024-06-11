package com.jc.hprest.hpdemo.rest;

import com.jc.hprest.hpdemo.daoimpl.PatientDAOimpl;
import com.jc.hprest.hpdemo.entity.Patient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class PatientRestController {

    private PatientDAOimpl patientDAOimpl;


    public PatientRestController(PatientDAOimpl patientDAOimpl){
        this.patientDAOimpl = patientDAOimpl;

    }

    @GetMapping("/patients")
    public List<Patient> findAll(){
        return patientDAOimpl.findAll();
    }









}
