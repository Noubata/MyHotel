package com.example.myhotel.services;

import com.example.myhotel.data.models.*;
import com.example.myhotel.data.repositories.BookingRepository;
import com.example.myhotel.data.repositories.GuestRepository;
import com.example.myhotel.data.repositories.RoomRepository;
import com.example.myhotel.dtos.Requests.BookRoomRequest;
import com.example.myhotel.dtos.Requests.CancelReservationRequest;
import com.example.myhotel.dtos.Responses.BookRoomResponse;
import com.example.myhotel.dtos.Responses.CancelReservationResponse;
import com.example.myhotel.dtos.Responses.ViewAvailableRoomResponse;
import com.example.myhotel.exceptions.BookingNotFoundException;
import com.example.myhotel.exceptions.GuestNotFoundException;
import com.example.myhotel.exceptions.RoomAlreadyBookedException;
import com.example.myhotel.exceptions.RoomNotFoundException;
import com.example.myhotel.utils.GuestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GuestServiceImplementation implements GuestService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private GuestRepository guestRepository;
    @Override
    public List<ViewAvailableRoomResponse> viewAvailableRoom() {
        List<Room> rooms = roomRepository.findAll();
        List<ViewAvailableRoomResponse> responses = new ArrayList<>();
        for(Room everyRoom: rooms){
            ViewAvailableRoomResponse response = GuestMapper.toResponse(everyRoom);
            responses.add(response);
        }
        return responses;
    }
    @Override
    public BookRoomResponse bookRoom(BookRoomRequest request) {
        Optional<Room> room = roomRepository.findById(request.getRoomId());
        if (!room.isPresent()) {
            throw new RoomNotFoundException("Room not found!");
        }
        Room roomToBook = room.get();
        if (roomToBook.getStatus() == RoomStatus.OCCUPIED) {
            throw new RoomAlreadyBookedException("Room already booked");
        }
        Optional<Guest> guest = guestRepository.findById(request.getGuestId());
        if (guest.isPresent()) {
            throw new GuestNotFoundException("Guest not found!");
        }
        Guest guestToBook = guest.get();

        Booking booking = new Booking();
        booking.setRoom(roomToBook);
        booking.setGuest(guestToBook);
        booking.setStatus(BookingStatus.CONFIRMED);
        booking.setCheckInDate(request.getCheckInDate());
        booking.setNumberOfNights(request.getNumberOfNights());
        roomToBook.setStatus(RoomStatus.OCCUPIED);
        roomRepository.save(roomToBook);
        Booking toSave = bookingRepository.save(booking);
        return GuestMapper.toResponseBookRoom(toSave);
    }
    @Override
    public CancelReservationResponse cancelReservation (CancelReservationRequest request){
        Optional<Booking> CancelBooking = bookingRepository.findById(request.getBookingReferenceId());
        if (!CancelBooking.isPresent()) {
            throw new BookingNotFoundException("Booking not found!");
        }
        Booking bookingToCancel = CancelBooking.get();
        if (bookingToCancel.getStatus() == BookingStatus.CANCELLED){
            throw new BookingNotFoundException("Booking already cancelled!");
        }
        bookingToCancel.setStatus(BookingStatus.CANCELLED);

        Booking cancelBooking = bookingRepository.save(bookingToCancel);
        Room room  = bookingToCancel.getRoom();
        room.setStatus(RoomStatus.AVAILABLE);
        roomRepository.save(room);

        return GuestMapper.toResponseCancelReservation(cancelBooking);
    }
}
