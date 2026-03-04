package com.example.myhotel.dtos.Responses;

import com.example.myhotel.data.models.RoomStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MarkRoomUnavailableResponse {
    private String message;
    private RoomStatus roomStatus;
}
