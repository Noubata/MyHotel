package com.example.myhotel.services;

import com.example.myhotel.data.models.RoomType;
import com.example.myhotel.dtos.Requests.*;
import com.example.myhotel.dtos.Responses.*;

public interface HotelService {
    CalculatePaymentResponse calculatePayment(CalculatePaymentRequest request);
    AddRoomsResponse addRooms(AddRoomsRequest request);
    ViewGuestDetailsResponse viewGuestDetails(ViewGuestDetailsRequest request);
    MarkRoomAvailableResponse markRoomAvailable(MarkRoomAvailableRequest request);
    MarkRoomUnavailableResponse markRoomUnavailable(MarkRoomUnavailableRequest request);
    NotifyGuestResponse  notifyGuest(NotifyGuestRequest request);
    LoginResponse login(LoginRequest request);

    GenerateReportResponse generateReports(GenerateReportRequest request);
}
