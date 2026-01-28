package com.example.myhotel.data.repositories;

import com.example.myhotel.data.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
