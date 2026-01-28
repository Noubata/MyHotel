package com.example.myhotel.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isFestivePeriod;
    public static final double FESTIVE_INCREASE = 0.2;
    private RoomType roomType;
    @ManyToOne(cascade = CascadeType.ALL)
    private Booking booking;
    private int numberOfNights;
}
