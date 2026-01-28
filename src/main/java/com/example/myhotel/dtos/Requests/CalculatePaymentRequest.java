package com.example.myhotel.dtos.Requests;

import com.example.myhotel.data.models.RoomType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CalculatePaymentRequest {
    @NotNull
    private int numberOfNights;
    @Enumerated(EnumType.STRING)
    @NotNull
    private RoomType roomType;
    @NotNull
    private boolean isFestivePeriod;
}
