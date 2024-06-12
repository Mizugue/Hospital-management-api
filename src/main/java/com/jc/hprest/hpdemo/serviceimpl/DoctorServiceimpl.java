package com.jc.hprest.hpdemo.serviceimpl;


import com.jc.hprest.hpdemo.dao.DoctorRepository;
import com.jc.hprest.hpdemo.entity.triad.Doctor;
import com.jc.hprest.hpdemo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceimpl implements DoctorService {

    private DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceimpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor findById(int id) {
        Optional<Doctor> result = doctorRepository.findById(id);
        Doctor doctor = null;

        if (result.isPresent()) {
            doctor = result.get();
        } else {
            throw new RuntimeException("Doctor id not found = " + id);
        }
        return doctor;
    }

    @Override
    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);

    }


    @Override
    public Doctor deleteById(int id) {
        Optional<Doctor> result = doctorRepository.findById(id);
        Doctor doctor = null;

        if (result.isPresent()) {
            doctor = result.get();
            doctorRepository.delete(doctor);
        } else {
            throw new RuntimeException("Doctor id not found = " + id);
        }
        return doctor;
    }
}
