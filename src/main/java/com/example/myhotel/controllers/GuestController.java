package com.example.myhotel.controllers;

import com.example.myhotel.dtos.Requests.BookRoomRequest;
import com.example.myhotel.dtos.Responses.APIResponse;
import com.example.myhotel.dtos.Responses.BookRoomResponse;
import com.example.myhotel.dtos.Responses.ViewAvailableRoomResponse;
import com.example.myhotel.services.GuestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/hotel")
public class GuestController {
    @Autowired
    private GuestService guestService;
    @GetMapping("/available-rooms")
    public ResponseEntity<APIResponse<List<ViewAvailableRoomResponse>>> viewAvailableRoom(){
        List<ViewAvailableRoomResponse> response = guestService.viewAvailableRoom();
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse<>(true, response));
    }
    @PostMapping("/book-room")
    public ResponseEntity<APIResponse<BookRoomResponse>> bookRoom(@RequestBody @Valid BookRoomRequest request){
        BookRoomResponse response = guestService.bookRoom(request);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse<>(true, response));
    }
}
