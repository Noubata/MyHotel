package com.example.myhotel.data.repositories;

import com.example.myhotel.data.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
