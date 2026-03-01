package com.example.myhotel.dtos.Responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenerateReportResponse {
    private long totalBookings;
    private long totalGuests;
    private double totalRevenue;
    private long availableRooms;
}
