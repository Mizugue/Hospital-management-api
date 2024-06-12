package com.jc.hprest.hpdemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "especialization")
public class DoctorEspecialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "especialization")
    private String especialization;

    public DoctorEspecialization(){
    }

    public DoctorEspecialization(String especialization) {
        this.especialization = especialization;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEspecialization() {
        return especialization;
    }

    public void setEspecialization(String especialization) {
        this.especialization = especialization;
    }

    @Override
    public String toString() {
        return "DoctorEspecialization{" +
                "id=" + id +
                ", especialization='" + especialization + '\'' +
                '}';
    }
}
