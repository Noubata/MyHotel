package com.example.myhotel.utils;

import com.example.myhotel.data.models.Room;
import com.example.myhotel.dtos.Requests.BookRoomRequest;
import com.example.myhotel.dtos.Responses.BookRoomResponse;
import com.example.myhotel.dtos.Responses.ViewAvailableRoomResponse;

public class GuestMapper {
    public static ViewAvailableRoomResponse toResponse(Room room) {
        return new ViewAvailableRoomResponse(
                room.getId(),
                room.getRoomType(),
                room.isStatus(),
                room.getRoomNumber()
        );
    }
    public static BookRoomResponse toResponseBookRoom(BookRoomRequest request) {
        BookRoomResponse response = new BookRoomResponse();
        response.setNumberOfNights(request.getNumberOfNights());
        response.setGuestName(request.getGuestName());
        response.setPhoneNumber(request.getPhoneNumber());
        response.setRoomType(request.getRoomType());
        return response;
    }
}
