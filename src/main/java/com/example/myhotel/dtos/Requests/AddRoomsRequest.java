package com.example.myhotel.dtos.Requests;

import com.example.myhotel.data.models.RoomStatus;
import com.example.myhotel.data.models.RoomType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddRoomsRequest {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private RoomType roomType;
    private String roomNumber;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private RoomStatus roomStatus;


}
