package com.example.myhotel.services;

import com.example.myhotel.data.models.Room;
import com.example.myhotel.data.repositories.RoomRepository;
import com.example.myhotel.dtos.Requests.BookRoomRequest;
import com.example.myhotel.dtos.Responses.BookRoomResponse;
import com.example.myhotel.dtos.Responses.ViewAvailableRoomResponse;
import com.example.myhotel.utils.GuestMapper;
import com.example.myhotel.utils.HotelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuestServiceImplementation implements GuestService {
    @Autowired
    private RoomRepository roomRepository;
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
//    @Override
//    public BookRoomResponse bookRoom(BookRoomRequest request){
//        BookRoomResponse response = new BookRoomResponse();
//        response.setNumberOfNights(request.getNumberOfNights());
//        response.setGuestName(request.getGuest().getFullName());
//        response.setPhoneNumber(request.getGuest().getPhoneNumber());
//        response.setRoom(request.getRoom().isStatus(true));
//        response.setRoomType(request.getRoom().getRoomType());
//        return Mapper.toBookRoomResponse();
//    }
    @Override
    public BookRoomResponse bookRoom(BookRoomRequest request) {
        if (!request.isStatus()) {
            throw new RuntimeException("Room already booked");
        }
        request.setStatus(false);
        return GuestMapper.toResponseBookRoom(request);
    }
}
