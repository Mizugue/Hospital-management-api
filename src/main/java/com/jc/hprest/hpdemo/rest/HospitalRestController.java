package com.jc.hprest.hpdemo.rest;


import com.jc.hprest.hpdemo.entity.triad.Hospital;
import com.jc.hprest.hpdemo.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitalRestController {


    private HospitalService hospitalService;

    @Autowired
    public HospitalRestController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }


    @GetMapping("")
    public List<Hospital> findAll() {
        return hospitalService.findAll();
    }

    @GetMapping("/{id}")
    public Hospital findById(@PathVariable int id) {
        Hospital hospital = hospitalService.findById(id);
        if (hospital == null) {
            throw new RuntimeException("Hospital id not found =" + id);
        }
        return hospital;
    }

    @PostMapping("")
    public Hospital saveHospital(@RequestBody Hospital hospital) {
        hospital.setId(0);
        Hospital hospital1 = hospitalService.save(hospital);
        return hospital1;
    }

    @PutMapping("")
    public Hospital updateHospital(@RequestBody Hospital hospital) {
        Hospital hospital1 = hospitalService.save(hospital);
        return hospital1;
    }

    @DeleteMapping("/{id}")
    public String deleteHospital(@PathVariable int id) {
        Hospital hospital = hospitalService.findById(id);
        if (hospital == null) {
            throw new RuntimeException("Hospital id not found = " + id);
        }
        hospitalService.deleteById(id);
        return "Deleted hospital = " + hospital;
    }

}
