package com.example.myhotel.dtos.Responses;

import com.example.myhotel.data.models.*;
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
public class BookRoomResponse {
    private String roomNumber;
    private String bookingReferenceNumber;
    //private double totalPrice;
    private BookingStatus status;
    private int numberOfNights;
    private String guestName;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;

}
