package com.jc.hprest.hpdemo.entity.thirdparty;

import com.jc.hprest.hpdemo.entity.states.AmbulanceState;
import jakarta.persistence.*;

@Entity
@Table(name = "ambulance")
public class Ambulance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "plate")
    private String plate;

    @ManyToOne
    @JoinColumn(name = "id_amb_state")
    private AmbulanceState ambulanceState;

    public Ambulance(){
    }


    public Ambulance(String plate, AmbulanceState ambulanceState) {
        this.plate = plate;
        this.ambulanceState = ambulanceState;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public AmbulanceState getAmbulanceState() {
        return ambulanceState;
    }

    public void setAmbulanceState(AmbulanceState ambulanceState) {
        this.ambulanceState = ambulanceState;
    }

    @Override
    public String toString() {
        return "Ambulance{" +
                "id=" + id +
                ", plate='" + plate + '\'' +
                ", ambulanceState=" + ambulanceState +
                '}';
    }
}
