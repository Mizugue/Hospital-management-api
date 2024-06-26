package com.jc.hprest.hpdemo.entity.triad;

import com.jc.hprest.hpdemo.entity.thirdparty.Attendant;
import com.jc.hprest.hpdemo.entity.services.Service;
import jakarta.persistence.*;

@Entity
@Table(name = "hospital")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "cep")
    private String cep;

    @ManyToOne
    @JoinColumn(name = "id_attendant")
    private Attendant attendant;

    @ManyToOne
    @JoinColumn(name = "id_service")
    private Service service;

    public Hospital(){
    }

    public Hospital(String name, String cep, Attendant attendant, Service service) {
        this.name = name;
        this.attendant = attendant;
        this.service = service;
        this.cep = cep;
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

    public Attendant getAttendant() {
        return attendant;
    }

    public void setAttendant(Attendant attendant) {
        this.attendant = attendant;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                "cep=" + cep +
                ", name='" + name + '\'' +
                ", attendant=" + attendant +
                ", service=" + service +
                '}';
    }
}
