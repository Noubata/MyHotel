package com.example.myhotel.services;

import com.example.myhotel.dtos.Requests.BookRoomRequest;
import com.example.myhotel.dtos.Responses.BookRoomResponse;
import com.example.myhotel.dtos.Responses.ViewAvailableRoomResponse;

import java.util.List;

public interface GuestService {
    List<ViewAvailableRoomResponse> viewAvailableRoom();
    BookRoomResponse bookRoom(BookRoomRequest bookRoomRequest);
}

