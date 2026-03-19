package com.example.myhotel.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class    Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private double amount;
    private boolean isFestivePeriod;
    private LocalDateTime dateTime;
    public static final double FESTIVE_INCREASE = 0.2;
    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
}
