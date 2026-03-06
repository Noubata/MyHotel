package com.example.myhotel.dtos.Requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotifyGuestRequest {
    private String bookingReference;
    private String email;
    private String guestName;
    private int numberOfNights;
    private double amountToPay;
}
