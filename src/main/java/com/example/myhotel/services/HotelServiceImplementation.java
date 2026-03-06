package com.example.myhotel.services;

import com.example.myhotel.data.models.*;
import com.example.myhotel.data.repositories.*;
import com.example.myhotel.dtos.Requests.*;
import com.example.myhotel.dtos.Responses.*;
import com.example.myhotel.exceptions.AdminNotFoundException;
import com.example.myhotel.exceptions.BookingNotFoundException;
import com.example.myhotel.exceptions.GuestNotFoundException;
import com.example.myhotel.exceptions.RoomNotFoundException;
import com.example.myhotel.utils.HotelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImplementation implements HotelService {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    GuestRepository guestRepository;
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    AdminRepository adminRepository;

    @Override
    public CalculatePaymentResponse calculatePayment(CalculatePaymentRequest request) {

        RoomType roomType = request.getRoomType();
        double normalDayTotal = request.getNumberOfNights() * roomType.getPricePerNight();
        double finalTotal = request.isFestivePeriod()
                ? normalDayTotal * (1 + Payment.FESTIVE_INCREASE)
                : normalDayTotal;
        return HotelMapper.toResponseCalculatePayment(finalTotal);
    }
    @Override
    public AddRoomsResponse addRooms(AddRoomsRequest request) {
        Room room = new Room();
        room.setRoomType(request.getRoomType());
        room.setRoomNumber(request.getRoomNumber());
        room.setStatus(request.getRoomStatus());
        Room savedRoom = roomRepository.save(room);
        return HotelMapper.toResponseAddRooms(savedRoom);
    }
    @Override
    public ViewGuestDetailsResponse viewGuestDetails(ViewGuestDetailsRequest request){
        Optional<Guest> potentialGuest = guestRepository.findByEmail(request.getGuestEmail());
        if (potentialGuest.isEmpty()){
            throw new GuestNotFoundException("Guest never existed!!");
        }
        Guest guest = potentialGuest.get();
        return HotelMapper.toResponseViewGuest(guest);
    }
    @Override
    public MarkRoomAvailableResponse markRoomAvailable(MarkRoomAvailableRequest request) {
        Optional<Room> potentialRoom = roomRepository.findFirstByRoomTypeAndStatus(
                request.getRoomType(), RoomStatus.OCCUPIED);
        if (potentialRoom.isEmpty()) {
            potentialRoom = roomRepository.findFirstByRoomTypeAndStatus(request.getRoomType(), RoomStatus.UNDER_MAINTENANCE);
        }
        if (potentialRoom.isEmpty()) {
            throw new RoomNotFoundException("Room never existed!!");
        }
        Room room = potentialRoom.get();
        room.setStatus(RoomStatus.AVAILABLE);
        Room savedRoom = roomRepository.save(room);
        return HotelMapper.toResponseMarkAvailable(savedRoom);
    }

    @Override
    public MarkRoomUnavailableResponse markRoomUnavailable(MarkRoomUnavailableRequest request){
        Optional<Room> potentialRoom  = roomRepository.findFirstByRoomTypeAndStatus(
                request.getRoomType(), RoomStatus.AVAILABLE);
        if (potentialRoom.isEmpty()){
            potentialRoom = roomRepository.findFirstByRoomTypeAndStatus(request.getRoomType(), RoomStatus.OCCUPIED);
        }
        if (potentialRoom.isEmpty()) {
            throw new RoomNotFoundException("Room never existed!!");
        }
        Room room = potentialRoom.get();
        room.setStatus(RoomStatus.OCCUPIED);
        Room savedRoom = roomRepository.save(room);
        return HotelMapper.toResponseMarkUnavailable(savedRoom);
    }
    @Override
    public NotifyGuestResponse notifyGuest(NotifyGuestRequest request) {
        Optional<Booking> potentialBooking = bookingRepository.findByBookingReferenceNumber(request.getBookingReference());
        if (potentialBooking.isEmpty()) {
            throw new BookingNotFoundException("Booking not found");
        }
        Booking booking = potentialBooking.get();
        booking.setStatus(BookingStatus.CONFIRMED);
        booking.setNumberOfNights(request.getNumberOfNights());
        booking.setBookingReferenceNumber(request.getBookingReference());
        booking.getGuest().getFullName();
        booking.getPayment().getAmount();
        bookingRepository.save(booking);
        return HotelMapper.toResponseNotifyGuest();
    }
    @Override
    public LoginResponse login(LoginRequest request){
        Optional<Admin> potentialAdmin = adminRepository.findByUsername(request.getUsername());
        if (potentialAdmin.isEmpty()){
            throw new AdminNotFoundException("Admin not found");
        }
        Admin admin = potentialAdmin.get();
        admin.setUsername(request.getUsername());
        admin.setPassword(request.getPassword());
        adminRepository.save(admin);
        return HotelMapper.toResponseLogin();
    }
    @Override
    public GenerateReportResponse generateReports(GenerateReportRequest request) {
        List<Booking> bookings = bookingRepository.findAll();
        long totalBookings = bookings.size();
        long totalGuests = 0;
        for (Booking booking : bookings){
            totalGuests += booking.getNumberOfGuests();
        }
        return HotelMapper.toGenerateReportResponse(totalBookings, totalGuests);
    }
}
