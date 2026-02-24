package com.example.myhotel.dtos.Responses;

import com.example.myhotel.data.models.RoomStatus;
import com.example.myhotel.data.models.RoomType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddRoomsResponse {
    private Long id;
    private String roomNumber;
    private RoomStatus status;
    private RoomType roomType;
}
