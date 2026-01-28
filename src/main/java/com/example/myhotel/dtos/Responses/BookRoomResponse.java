package com.example.myhotel.dtos.Responses;

import com.example.myhotel.data.models.Guest;
import com.example.myhotel.data.models.Payment;
import com.example.myhotel.data.models.Room;
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
public class BookRoomResponse {
    private String roomNumber;
    private String bookingReferenceNumber;
    private double totalPrice;
    private int numberOfNights;
    private String guestName;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;

}
