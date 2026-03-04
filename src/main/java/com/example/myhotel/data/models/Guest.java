package com.example.myhotel.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    @JoinColumn(name = "booking_id")
    private List<Booking> bookings;
    @Column(unique = true, nullable = false)
    private String email;
    private String fullName;
    private String phoneNumber;
    @OneToMany(mappedBy = "guest", cascade = CascadeType.ALL)
    private List<Notifications> notifications = new ArrayList<>();
}
