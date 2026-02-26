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
    private BookingStatus status;
    @Column(unique = true)
    private String bookingRoomNumber;
    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;
    private int numberOfNights;
    @OneToOne(mappedBy = "booking")
    private Payment payment;
    @OneToOne
    @JoinColumn(name = "room_id")
    private Room room;
//    @ManyToOne
//    @JoinColumn(name = "hotel_id")
//    private Hotel hotel;
    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;

}
