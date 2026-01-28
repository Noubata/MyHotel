package com.example.myhotel.controllers;

import com.example.myhotel.dtos.Requests.CalculatePaymentRequest;
import com.example.myhotel.dtos.Requests.ViewAvailableRoomRequest;
import com.example.myhotel.dtos.Responses.APIResponse;
import com.example.myhotel.dtos.Responses.CalculatePaymentResponse;
import com.example.myhotel.dtos.Responses.ViewAvailableRoomResponse;
import com.example.myhotel.services.GuestService;
import com.example.myhotel.services.HotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/hotel")
public class HotelController {
    @Autowired
    HotelService hotelService;
    @Autowired
    GuestService guestService;

    @PostMapping("/payment")
    public ResponseEntity<APIResponse <CalculatePaymentResponse>> calculatePayment(@Valid @RequestBody CalculatePaymentRequest request){
        CalculatePaymentResponse response = hotelService.calculatePayment(request);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse<>(true, response));
    }

}
