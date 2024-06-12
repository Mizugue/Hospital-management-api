package com.jc.hprest.hpdemo.dao;

import com.jc.hprest.hpdemo.entity.thirdparty.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
