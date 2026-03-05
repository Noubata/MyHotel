package com.example.myhotel.controllers;

import com.example.myhotel.dtos.Requests.AddRoomsRequest;
import com.example.myhotel.dtos.Requests.CalculatePaymentRequest;
import com.example.myhotel.dtos.Requests.ViewGuestDetailsRequest;
import com.example.myhotel.dtos.Responses.APIResponse;
import com.example.myhotel.dtos.Responses.AddRoomsResponse;
import com.example.myhotel.dtos.Responses.CalculatePaymentResponse;
import com.example.myhotel.dtos.Responses.ViewGuestDetailsResponse;
import com.example.myhotel.services.HotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/hotel")
public class HotelController {
    @Autowired
    HotelService hotelService;

    @PostMapping("/payment")
    public ResponseEntity<APIResponse <CalculatePaymentResponse>> calculatePayment(@Valid @RequestBody CalculatePaymentRequest request){
        CalculatePaymentResponse response = hotelService.calculatePayment(request);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse<>(true, response));
    }

    @PostMapping("/adding-rooms")
    public ResponseEntity<APIResponse <AddRoomsResponse>> addRooms(@Valid @RequestBody AddRoomsRequest request){
        AddRoomsResponse response = hotelService.addRooms(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new APIResponse<>(true, response));
    }

    @GetMapping("/viewing-details")
    public ResponseEntity<APIResponse<ViewGuestDetailsResponse>> viewGuestDetails(@Valid @RequestBody ViewGuestDetailsRequest request){
        ViewGuestDetailsResponse response = hotelService.viewGuestDetails(request);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse<>(true, response));
    }
}
