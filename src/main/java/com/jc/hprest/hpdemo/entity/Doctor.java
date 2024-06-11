package com.jc.hprest.hpdemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "crm")
    private String crm;

    @ManyToOne
    @JoinColumn(name = "id_specialization")
    private DoctorEspecialization doctorEspecialization;

    @ManyToOne
    @JoinColumn(name = "id_doc_state")
    private DoctorState doctorState;

    public Doctor(){
    }

    public Doctor(String name, String crm, DoctorState doctorState, DoctorEspecialization doctorEspecialization) {
        this.name = name;
        this.crm = crm;
        this.doctorState = doctorState;
        this.doctorEspecialization = doctorEspecialization;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public DoctorState getDoctorState() {
        return doctorState;
    }

    public void setDoctorState(DoctorState doctorState) {
        this.doctorState = doctorState;
    }

    public DoctorEspecialization getDoctorEspecialization() {
        return doctorEspecialization;
    }

    public void setDoctorEspecialization(DoctorEspecialization doctorEspecialization) {
        this.doctorEspecialization = doctorEspecialization;
    }
}
