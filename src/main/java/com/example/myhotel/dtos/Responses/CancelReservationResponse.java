package com.example.myhotel.dtos.Responses;

import com.example.myhotel.data.models.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CancelReservationResponse {
    private BookingStatus status;
    private Long bookingReferenceId;
    private String message;
    private LocalDateTime cancellationDate;
    private String roomNumber;
}
