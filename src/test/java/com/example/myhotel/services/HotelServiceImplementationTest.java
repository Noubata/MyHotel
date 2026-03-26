package com.example.myhotel.services;

import com.example.myhotel.data.models.*;
import com.example.myhotel.data.repositories.GuestRepository;
import com.example.myhotel.data.repositories.RoomRepository;
import com.example.myhotel.dtos.Requests.*;
import com.example.myhotel.dtos.Responses.*;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static com.example.myhotel.data.models.RoomType.SINGLE;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
@Transactional
class HotelServiceImplementationTest {

    @Autowired
    private HotelService hotelService;
    @Autowired
    private GuestService guestService;
    @Autowired
    private GuestRepository guestRepository;
    @Autowired
    private RoomRepository roomRepository;

    @Test
    void testBookRoom_and_CalculatePayment() {
        Guest guest = new Guest();
        guest.setFullName("Beny");
        guest.setEmail("beny@gmail.com");
        guest.setPhoneNumber("12345678");
        guestRepository.save(guest);

        Room room = new Room();
        room.setRoomNumber("001");
        room.setRoomType(SINGLE);
        room.setStatus(RoomStatus.AVAILABLE);
        roomRepository.save(room);

        BookRoomRequest bookRoomRequest = new BookRoomRequest();
        bookRoomRequest.setGuestName("Beny");
        bookRoomRequest.setNumberOfNights(3);
        bookRoomRequest.setRoomNumber("001");
        bookRoomRequest.setCheckInDate(LocalDateTime.now());
        bookRoomRequest.setPhoneNumber("12345678");
        bookRoomRequest.setEmail("beny@gmail.com");
        bookRoomRequest.setRoomType(SINGLE);
        bookRoomRequest.setStatus(BookingStatus.CONFIRMED);
        guestService.bookRoom(bookRoomRequest);

        CalculatePaymentRequest calculatePaymentRequest = new CalculatePaymentRequest();
        calculatePaymentRequest.setRoomType(SINGLE);
        calculatePaymentRequest.setNumberOfNights(3);
        calculatePaymentRequest.setFestivePeriod(false);

        CalculatePaymentResponse toCalculate = hotelService.calculatePayment(calculatePaymentRequest);
        assertNotNull(toCalculate);
        assertEquals(30000.0, toCalculate.getAmountToPay());
    }
    @Test
    void testAddRoms(){
        AddRoomsRequest addRoomsRequest = new AddRoomsRequest();
        addRoomsRequest.setRoomNumber("001");
        addRoomsRequest.setRoomStatus(RoomStatus.AVAILABLE);
        addRoomsRequest.setRoomType(RoomType.DOUBLE);

        AddRoomsResponse toAdd = hotelService.addRooms(addRoomsRequest);
        assertNotNull(toAdd);
        assertEquals("001", toAdd.getRoomNumber());
    }
    @Test
    void testViewGuestDetails(){
        Guest guest = new Guest();
        guest.setFullName("Beny");
        guest.setEmail("beny@gmail.com");
        guest.setPhoneNumber("12345678");
        guestRepository.save(guest);

        Room room = new Room();
        room.setRoomNumber("001");
        room.setRoomType(SINGLE);
        room.setStatus(RoomStatus.AVAILABLE);
        roomRepository.save(room);

//        BookRoomRequest bookRoomRequest = new BookRoomRequest();
//        bookRoomRequest.setGuestName("Beny");
//        bookRoomRequest.setNumberOfNights(3);
//        bookRoomRequest.setRoomNumber("001");
//        bookRoomRequest.setCheckInDate(LocalDateTime.now());
//        bookRoomRequest.setPhoneNumber("12345678");
//        bookRoomRequest.setEmail("beny@gmail.com");
//        bookRoomRequest.setRoomType(SINGLE);
//        bookRoomRequest.setStatus(BookingStatus.CONFIRMED);
//        guestService.bookRoom(bookRoomRequest);

        ViewGuestDetailsRequest viewGuestDetailsRequest = new ViewGuestDetailsRequest();
        viewGuestDetailsRequest.setGuestEmail("beny@gmail.com");
        ViewGuestDetailsResponse toView = hotelService.viewGuestDetails(viewGuestDetailsRequest);
        assertNotNull(toView);
        assertEquals("Beny", toView.getGuestName());
        assertEquals("12345678", toView.getGuestPhone());
    }
    @Test
    void testMarkRoomAvailable(){
        Room room = new Room();
        room.setRoomNumber("001");
        room.setRoomType(SINGLE);
        room.setStatus(RoomStatus.OCCUPIED);
        roomRepository.save(room);

        MarkRoomAvailableRequest markRoomAvailableRequest = new MarkRoomAvailableRequest();
        markRoomAvailableRequest.setRoomNumber(room.getRoomNumber());
        markRoomAvailableRequest.setRoomStatus(RoomStatus.AVAILABLE);
        markRoomAvailableRequest.setRoomType(SINGLE);

        MarkRoomAvailableResponse toMark = hotelService.markRoomAvailable(markRoomAvailableRequest);
        assertNotNull(toMark);
        assertEquals(RoomStatus.AVAILABLE, toMark.getRoomStatus());
    }
    @Test
    void testMarkRoomUnavailable(){
        Room room = new Room();
        room.setRoomNumber("001");
        room.setRoomType(SINGLE);
        room.setStatus(RoomStatus.AVAILABLE);
        roomRepository.save(room);

        MarkRoomUnavailableRequest markRoomUnavailableRequest = new MarkRoomUnavailableRequest();
        markRoomUnavailableRequest.setRoomNumber(room.getRoomNumber());
        markRoomUnavailableRequest.setRoomStatus(RoomStatus.UNDER_MAINTENANCE);
        markRoomUnavailableRequest.setRoomType(SINGLE);

        MarkRoomUnavailableResponse toMark = hotelService.markRoomUnavailable(markRoomUnavailableRequest);
        assertNotNull(toMark);
        assertEquals(RoomStatus.OCCUPIED, toMark.getRoomStatus());
    }
    @Test
    void testNotifyGuest(){
        Guest guest = new Guest();
        guest.setFullName("Beny");
        guest.setEmail("beny@gmail.com");
        guest.setPhoneNumber("12345678");
        guestRepository.save(guest);

        Room room = new Room();
        room.setRoomNumber("001");
        room.setRoomType(SINGLE);
        room.setStatus(RoomStatus.AVAILABLE);
        roomRepository.save(room);

        Booking booking = new Booking();
        booking.setCheckOutDate(LocalDateTime.now());

        NotifyGuestRequest notifyGuestRequest = new NotifyGuestRequest();
        notifyGuestRequest.setGuestName("Beny");
        notifyGuestRequest.setNumberOfNights(3);
    }
}