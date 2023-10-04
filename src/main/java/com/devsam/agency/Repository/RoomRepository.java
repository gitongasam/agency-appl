package com.devsam.agency.Repository;

import com.devsam.agency.Entity.Property;
import com.devsam.agency.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
//    List<Room> findByProperty(Property property);
}

