package com.example.myhotel.utils;

import com.example.myhotel.data.models.Booking;
import com.example.myhotel.data.models.Room;
import com.example.myhotel.data.repositories.BookingRepository;
import com.example.myhotel.data.repositories.RoomRepository;
import com.example.myhotel.dtos.Requests.BookRoomRequest;
import com.example.myhotel.dtos.Requests.CancelReservationRequest;
import com.example.myhotel.dtos.Responses.BookRoomResponse;
import com.example.myhotel.dtos.Responses.CancelReservationResponse;
import com.example.myhotel.dtos.Responses.ViewAvailableRoomResponse;
import org.springframework.beans.factory.annotation.Autowired;

public class GuestMapper {
    public static ViewAvailableRoomResponse toResponse(Room room) {
        return new ViewAvailableRoomResponse(
                room.getId(),
                room.getRoomType(),
                room.getStatus(),
                room.getRoomNumber()
        );
    }
    public static BookRoomResponse toResponseBookRoom(Booking booking) {
        BookRoomResponse response = new BookRoomResponse();
        response.setBookingReferenceNumber(booking.getBookingRoomNumber());
        response.setRoomType(booking.getRoom().getRoomType());
        response.setRoomNumber(booking.getRoom().getRoomNumber());
        response.setNumberOfNights(booking.getNumberOfNights());
        response.setCheckInDate(booking.getCheckInDate());
        response.setCheckOutDate(booking.getCheckOutDate());
        response.setStatus(booking.getStatus());
        return response;
    }

    public static CancelReservationResponse toResponseCancelReservation(Booking booking) {
        CancelReservationResponse response = new CancelReservationResponse();
        response.setBookingReferenceId(booking.getId());
        response.setMessage("Booking cancelled successfully!");
        response.setCancellationDate(booking.getCheckInDate());
        response.setRoomNumber(booking.getRoom().getRoomNumber());
        response.setStatus(booking.getStatus());
        return response;
    }
}
