package com.jc.hprest.hpdemo.entity;

import jakarta.persistence.*;

public class RoomState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private RoomStateEnum roomStateEnum;

    public enum RoomStateEnum{
        occupied,
        vacant
    }

    public RoomState(){
    }

    public RoomState(RoomStateEnum roomStateEnum) {
        this.roomStateEnum = roomStateEnum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoomStateEnum getRoomStateEnum() {
        return roomStateEnum;
    }

    public void setRoomStateEnum(RoomStateEnum roomStateEnum) {
        this.roomStateEnum = roomStateEnum;
    }

    @Override
    public String toString() {
        return "RoomState{" +
                "id=" + id +
                ", roomStateEnum=" + roomStateEnum +
                '}';
    }
}
