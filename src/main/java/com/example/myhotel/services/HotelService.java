package com.example.myhotel.services;

import com.example.myhotel.data.models.RoomType;
import com.example.myhotel.dtos.Requests.CalculatePaymentRequest;
import com.example.myhotel.dtos.Responses.CalculatePaymentResponse;

public interface HotelService {
    CalculatePaymentResponse calculatePayment(CalculatePaymentRequest request);
}
