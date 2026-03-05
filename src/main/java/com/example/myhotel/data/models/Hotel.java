package com.example.myhotel.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hotelName;
    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;
//    @OneToMany(mappedBy = "hotel")
//    private List<Guest> guest;
//    @OneToMany(mappedBy = "hotel")
//    private List<Booking> booking;
}
