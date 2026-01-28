package com.example.myhotel.utils;

import com.example.myhotel.dtos.Responses.CalculatePaymentResponse;

public class HotelMapper {
    public static CalculatePaymentResponse toResponseCalculatePayment(double amount) {
        return new CalculatePaymentResponse(amount);
    }
}
