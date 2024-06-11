package com.jc.hprest.hpdemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "doctor_state")
public class DoctorState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private DoctorStateEnum state;

    public enum DoctorStateEnum {
        busy,
        unoccupied,
    }

    public DoctorState(){
    }

    public DoctorState(DoctorStateEnum state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DoctorStateEnum getState() {
        return state;
    }

    public void setState(DoctorStateEnum state) {
        this.state = state;
    }
}
