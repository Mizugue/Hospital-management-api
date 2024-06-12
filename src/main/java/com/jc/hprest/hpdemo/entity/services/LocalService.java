package com.jc.hprest.hpdemo.entity.services;

import jakarta.persistence.*;

@Entity
@Table(name= "local_service")
public class LocalService {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_hospitalization")
    private Hospitalization hospitalization;

    public LocalService(){
    }


    public LocalService(Hospitalization hospitalization) {
        this.hospitalization = hospitalization;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hospitalization getHospitalization() {
        return hospitalization;
    }

    public void setHospitalization(Hospitalization hospitalization) {
        this.hospitalization = hospitalization;
    }

    @Override
    public String toString() {
        return "LocalService{" +
                "id=" + id +
                ", hospitalization=" + hospitalization +
                '}';
    }
}
