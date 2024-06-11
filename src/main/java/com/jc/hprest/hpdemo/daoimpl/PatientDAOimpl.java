package com.jc.hprest.hpdemo.daoimpl;

import com.jc.hprest.hpdemo.dao.PatientDAO;
import com.jc.hprest.hpdemo.entity.Patient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientDAOimpl implements PatientDAO {


    private EntityManager entityManager;

    @Autowired
    public PatientDAOimpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }



    @Override
    public List<Patient> findAll() {
        TypedQuery<Patient> query = entityManager.createQuery("from Patient", Patient.class);
        List<Patient> patients = query.getResultList();
        return patients;

    }
}