package com.example.myhotel.dtos.Requests;

import com.example.myhotel.data.models.BookingStatus;
import com.example.myhotel.data.models.RoomType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookRoomRequest {
    private Long roomId;
    private Long guestId;
    private LocalDateTime checkInDate;
    private int numberOfNights;
    private BookingStatus status;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    private String guestName;
    private String phoneNumber;

}