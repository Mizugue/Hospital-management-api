package com.jc.hprest.hpdemo.rest;

import com.jc.hprest.hpdemo.entity.Doctor;
import com.jc.hprest.hpdemo.entity.Patient;
import com.jc.hprest.hpdemo.service.DoctorService;
import com.jc.hprest.hpdemo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/hospital")
public class DoctorRestController {


    private DoctorService doctorService;

    @Autowired
    public DoctorRestController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctors")
    public List<Doctor> findAll(){
        return doctorService.findAll();
    }

    @GetMapping("/doctors/{id}")
    public Doctor findById(@PathVariable int id){
        Doctor doctor = doctorService.findById(id);
        if (doctor == null){
            throw new RuntimeException("Doctor id not found =" + id);
        }
        return doctor;
    }


    @PostMapping("/doctors")
    public Doctor saveDoctor(@RequestBody Doctor doctor){
        doctor.setId(0);
        Doctor doctor1 = doctorService.save(doctor);
        return doctor1;
    }

    @PutMapping("/doctors")
    public Doctor updateDoctor(@RequestBody Doctor doctor){
        Doctor doctor1 = doctorService.save(doctor);
        return doctor1;
    }

    @DeleteMapping("/doctors/{id}")
    public String deleteDoctor(@PathVariable int id) {
        Doctor doctor = doctorService.findById(id);
        if (doctor == null) {
            throw new RuntimeException("Doctor id not found = " + id);
        }
        doctorService.deleteById(id);
        return "Deleted doctor = " + doctor;
    }

}
