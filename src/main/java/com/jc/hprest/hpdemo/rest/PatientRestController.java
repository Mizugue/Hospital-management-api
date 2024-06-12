package com.jc.hprest.hpdemo.rest;

import com.jc.hprest.hpdemo.entity.triad.Patient;
import com.jc.hprest.hpdemo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/patients/{id}")
    public Patient findById(@PathVariable int id){
        Patient patient = patientService.findById(id);
        if (patient == null){
            throw new RuntimeException("Patient id not found =" + id);
        }
        return patient;
    }


    @PostMapping("/patients")
    public Patient savePacient(@RequestBody Patient patient){
        patient.setId(0);
        Patient patient1 = patientService.save(patient);
        return patient1;
    }

    @PutMapping("/patients")
    public Patient updatePatient(@RequestBody Patient patient){
        Patient patient1 = patientService.save(patient);
        return patient1;
    }

    @DeleteMapping("/patients/{id}")
    public String deletePatient(@PathVariable int id) {
        Patient patient = patientService.findById(id);
        if (patient == null) {
            throw new RuntimeException("Patient id not found = " + id);
        }
        patientService.deleteById(id);
        return "Deleted patient = " + patient;
    }

}
