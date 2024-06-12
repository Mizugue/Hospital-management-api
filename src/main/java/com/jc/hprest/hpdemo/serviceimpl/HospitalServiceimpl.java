package com.jc.hprest.hpdemo.serviceimpl;

import com.jc.hprest.hpdemo.dao.HospitalRepository;
import com.jc.hprest.hpdemo.entity.triad.Hospital;
import com.jc.hprest.hpdemo.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalServiceimpl implements HospitalService {

    private HospitalRepository hospitalRepository;

    @Autowired
    public HospitalServiceimpl(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }


    @Override
    public List<Hospital> findAll() {
        return hospitalRepository.findAll();
    }

    @Override
    public Hospital findById(int id) {
        Optional<Hospital> result = hospitalRepository.findById(id);
        Hospital hospital = null;
        if (result.isPresent()){
            hospital = result.get();
        } else {
            throw new RuntimeException("Hospital id not found = " + id );
        }
        return hospital;
    }

    @Override
    public Hospital save(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    @Override
    public Hospital deleteById(int id) {
        Optional<Hospital> result = hospitalRepository.findById(id);
        Hospital hospital = null;
        if (result.isPresent()){
            hospital = result.get();
            hospitalRepository.deleteById(id);
        } else {
            throw new RuntimeException("Hospital id not found = " + id );
        }
        return hospital;
    }
}
