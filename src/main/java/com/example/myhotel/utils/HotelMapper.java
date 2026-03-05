package com.example.myhotel.utils;

import com.example.myhotel.data.models.Guest;
import com.example.myhotel.data.models.Room;
import com.example.myhotel.data.models.RoomStatus;
import com.example.myhotel.dtos.Responses.*;

public class HotelMapper {
    public static CalculatePaymentResponse toResponseCalculatePayment(double amount) {
        return new CalculatePaymentResponse(amount);
    }

    public static AddRoomsResponse toResponseAddRooms(Room room) {
        AddRoomsResponse  addRoomsResponse = new AddRoomsResponse();
        addRoomsResponse.setStatus(room.getStatus());
        addRoomsResponse.setRoomType(room.getRoomType());
        addRoomsResponse.setRoomNumber(room.getRoomNumber());
        return addRoomsResponse;
    }

    public static ViewGuestDetailsResponse toResponseViewGuest(Guest guest) {
        ViewGuestDetailsResponse response = new ViewGuestDetailsResponse();
        response.setGuestName(guest.getFullName());
        response.setGuestEmail(guest.getEmail());
        response.setGuestPhone(guest.getPhoneNumber());
        return response;
    }

    public static MarkRoomAvailableResponse toResponseMarkAvailable(Room savedRoom) {
        MarkRoomAvailableResponse response = new MarkRoomAvailableResponse();
        response.setRoomStatus(RoomStatus.AVAILABLE);
        response.setMessage("room" + savedRoom.getRoomNumber() + "is available");
        return response;
    }

    public static MarkRoomUnavailableResponse toResponseMarkUnavailable(Room savedRoom) {
        MarkRoomUnavailableResponse response = new MarkRoomUnavailableResponse();
        response.setRoomStatus(RoomStatus.OCCUPIED);
        response.setMessage("room" + savedRoom.getRoomNumber() + "is unavailable");
        return response;
    }

    public static NotifyGuestResponse toResponseNotifyGuest() {
        NotifyGuestResponse response = new NotifyGuestResponse();
        response.setMessage("room booked successfully!");
        return response;
    }

    public static LoginResponse toResponseLogin() {
        LoginResponse response = new LoginResponse();
        response.setMessage("login successfully!");
        return response;
    }

    public static GenerateReportResponse toGenerateReportResponse(long totalBookings, long totalGuests) {
        GenerateReportResponse response = new GenerateReportResponse();
        response.setTotalGuests(totalGuests);
        response.setTotalBookings(totalBookings);
        return response;
    }
}
