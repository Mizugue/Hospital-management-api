package com.jc.hprest.hpdemo.entity;


import jakarta.persistence.*;


@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "cep")
    private String cep;

    @Column(name = "sickness")
    private String sickness;

    @Column(name = "state")
    private String state;

    @ManyToOne
    @JoinColumn(name = "id_pat_state")
    private PatientState patientState;

    public Patient(){
    }

    public Patient(String name, String cep, String sickness, String state, PatientState patientState) {
        this.name = name;
        this.cep = cep;
        this.sickness = sickness;
        this.state = state;
        this.patientState = patientState;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getSickness() {
        return sickness;
    }

    public void setSickness(String sickness) {
        this.sickness = sickness;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public PatientState getPatientState() {
        return patientState;
    }

    public void setPatientState(PatientState patientState) {
        this.patientState = patientState;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cep='" + cep + '\'' +
                ", sickness='" + sickness + '\'' +
                ", state='" + state + '\'' +
                ", patientState=" + patientState +
                '}';
    }
}

