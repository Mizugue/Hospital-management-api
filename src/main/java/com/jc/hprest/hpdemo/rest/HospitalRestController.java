package com.jc.hprest.hpdemo.rest;


import com.jc.hprest.hpdemo.entity.Hospital;
import com.jc.hprest.hpdemo.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hp")
public class HospitalRestController {


    private HospitalService hospitalService;

    @Autowired
    public HospitalRestController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }


    @GetMapping("/hps")
    public List<Hospital> findAll() {
        return hospitalService.findAll();
    }

    @GetMapping("/hps/{id}")
    public Hospital findById(@PathVariable int id) {
        Hospital hospital = hospitalService.findById(id);
        if (hospital == null) {
            throw new RuntimeException("Hospital id not found =" + id);
        }
        return hospital;
    }

    @PostMapping("/hps")
    public Hospital saveHospital(@RequestBody Hospital hospital) {
        hospital.setId(0);
        Hospital hospital1 = hospitalService.save(hospital);
        return hospital1;
    }

    @PutMapping("/hps")
    public Hospital updateHospital(@RequestBody Hospital hospital) {
        Hospital hospital1 = hospitalService.save(hospital);
        return hospital1;
    }

    @DeleteMapping("/hps/{id}")
    public String deleteHospital(@PathVariable int id) {
        Hospital hospital = hospitalService.findById(id);
        if (hospital == null) {
            throw new RuntimeException("Hospital id not found = " + id);
        }
        hospitalService.deleteById(id);
        return "Deleted hospital = " + hospital;
    }

}
