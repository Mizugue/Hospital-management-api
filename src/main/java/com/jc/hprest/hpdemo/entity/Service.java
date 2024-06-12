package com.jc.hprest.hpdemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_local_service")
    private LocalService localService;

    @ManyToOne
    @JoinColumn(name = "id_emergency_service")
    private EmergencyService emergencyService;

    public Service(){
    }

    public Service(LocalService localService, EmergencyService emergencyService) {
        this.localService = localService;
        this.emergencyService = emergencyService;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalService getLocalService() {
        return localService;
    }

    public void setLocalService(LocalService localService) {
        this.localService = localService;
    }

    public EmergencyService getEmergencyService() {
        return emergencyService;
    }

    public void setEmergencyService(EmergencyService emergencyService) {
        this.emergencyService = emergencyService;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", localService=" + localService +
                ", emergencyService=" + emergencyService +
                '}';
    }
}
