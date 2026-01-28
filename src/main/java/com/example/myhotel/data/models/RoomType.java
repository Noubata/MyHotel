package com.example.myhotel.data.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoomType {
    SINGLE(10000),
    DOUBLE(17500),
    SUITE(30000);
    private final double pricePerNight;
}
