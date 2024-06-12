package com.jc.hprest.hpdemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "hospitalization")
public class Hospitalization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_doctor")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "id_patient")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "id_room")
    private Room room;

    public Hospitalization(){
    }

    public Hospitalization(Doctor doctor, Patient patient, Room room) {
        this.doctor = doctor;
        this.patient = patient;
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Hospitalization{" +
                "id=" + id +
                ", doctor=" + doctor +
                ", patient=" + patient +
                ", room=" + room +
                '}';
    }
}
