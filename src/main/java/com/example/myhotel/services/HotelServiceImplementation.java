package com.example.myhotel.services;

import com.example.myhotel.data.models.Payment;
import com.example.myhotel.data.models.RoomType;
import com.example.myhotel.dtos.Requests.CalculatePaymentRequest;
import com.example.myhotel.dtos.Responses.CalculatePaymentResponse;
import com.example.myhotel.utils.HotelMapper;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImplementation implements HotelService {
    @Override
    public CalculatePaymentResponse calculatePayment(CalculatePaymentRequest request){
        RoomType price = RoomType.SINGLE;
        double normalDayTotal = request.getNumberOfNights() * price.getPricePerNight();
        double festiveDayTotal = request.isFestivePeriod() ? normalDayTotal * Payment.FESTIVE_INCREASE + normalDayTotal: normalDayTotal;
        return HotelMapper.toResponseCalculatePayment(festiveDayTotal);
    }
}
