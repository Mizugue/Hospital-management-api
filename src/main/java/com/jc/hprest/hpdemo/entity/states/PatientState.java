package com.jc.hprest.hpdemo.entity.states;


import jakarta.persistence.*;


@Entity
@Table(name = "patient_state")
public class PatientState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private PatientStateEnum state;

    public enum PatientStateEnum {
        discharged,
        not_discharged
    }

    public PatientState(){
    }

    public PatientState(PatientStateEnum state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PatientStateEnum getState() {
        return state;
    }

    public void setState(PatientStateEnum state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "PatientState{" +
                "id=" + id +
                ", state=" + state +
                '}';
    }
}