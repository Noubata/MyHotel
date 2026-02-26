package com.example.myhotel.dtos.Requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CancelReservationRequest {
    private String bookingReferenceNumber;
    private String guestName;
    private String phoneNumber;
}
