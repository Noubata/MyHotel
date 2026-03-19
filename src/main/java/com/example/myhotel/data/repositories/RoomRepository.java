package com.example.myhotel.data.repositories;

import com.example.myhotel.data.models.Room;
import com.example.myhotel.data.models.RoomStatus;
import com.example.myhotel.data.models.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findFirstByRoomTypeAndStatus(RoomType roomType, RoomStatus roomStatus);
}
