package com.example.myhotel.dtos.Requests;

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
public class MarkRoomUnavailableRequest {
    private RoomStatus roomStatus;
    private String roomNumber;
    private RoomType roomType;
}
