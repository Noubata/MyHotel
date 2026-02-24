package com.example.myhotel.dtos.Requests;

import com.example.myhotel.data.models.RoomStatus;
import com.example.myhotel.data.models.RoomType;

public class AddRoomsRequest {
    private RoomType roomType;
    private String roomNumber;
    private RoomStatus roomStatus;

    public AddRoomsRequest(RoomType roomType, String roomNumber, RoomStatus roomStatus) {
        this.roomType = roomType;
        this.roomStatus = roomStatus;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }
}
