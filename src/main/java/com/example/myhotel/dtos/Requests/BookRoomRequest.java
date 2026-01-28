package com.example.myhotel.dtos.Requests;

import com.example.myhotel.data.models.RoomType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookRoomRequest {
    private int numberOfNights;
    private boolean status;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    private String guestName;
    private String phoneNumber;

}