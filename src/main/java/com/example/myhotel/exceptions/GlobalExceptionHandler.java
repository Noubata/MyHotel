package com.example.myhotel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RoomAlreadyBookedException.class)
    public ResponseEntity<String> handleRoomBooked(RoomAlreadyBookedException error) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error.getMessage());
    }
    @ExceptionHandler(RoomNotFoundException.class)
    public ResponseEntity<String> roomNotFound(RoomNotFoundException error) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
    }
    @ExceptionHandler(GuestNotFoundException.class)
    public ResponseEntity<String> guestNotFound(GuestNotFoundException error){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
    }
}
