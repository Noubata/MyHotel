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
public class ViewAvailableRoomResponse {
    private Long id;
    private RoomType roomType;
    private RoomStatus status;
    private String roomNumber;
}
