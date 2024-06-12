package com.jc.hprest.hpdemo.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "emergency_service")
public class EmergencyService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn("id_ambulance")
    private Ambulance ambulance;

    public EmergencyService(){
    }


    public EmergencyService(Ambulance ambulance) {
        this.ambulance = ambulance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ambulance getAmbulance() {
        return ambulance;
    }

    public void setAmbulance(Ambulance ambulance) {
        this.ambulance = ambulance;
    }

    @Override
    public String toString() {
        return "EmergencyService{" +
                "id=" + id +
                ", ambulance=" + ambulance +
                '}';
    }
}
