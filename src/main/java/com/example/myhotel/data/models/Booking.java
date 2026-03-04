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
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numberOfGuests;
    private BookingStatus status;
    @Column(unique = true)
    private String bookingReferenceNumber;
    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;
    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;
    private int numberOfNights;
    @OneToOne
    @JoinColumn(name = "room_id")
    private Room room;
    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;

}
