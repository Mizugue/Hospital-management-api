package com.jc.hprest.hpdemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ambulance_state")
public class AmbulanceState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private AmbulanceStateEnum AmbulanceStateEnum;

    public enum AmbulanceStateEnum {
        parked,
        active
    }

    public AmbulanceState(){
    }

    public AmbulanceState(AmbulanceState.AmbulanceStateEnum ambulanceStateEnum) {
        AmbulanceStateEnum = ambulanceStateEnum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AmbulanceState.AmbulanceStateEnum getAmbulanceStateEnum() {
        return AmbulanceStateEnum;
    }

    public void setAmbulanceStateEnum(AmbulanceState.AmbulanceStateEnum ambulanceStateEnum) {
        AmbulanceStateEnum = ambulanceStateEnum;
    }

    @Override
    public String toString() {
        return "AmbulanceState{" +
                "id=" + id +
                ", AmbulanceStateEnum=" + AmbulanceStateEnum +
                '}';
    }
}
