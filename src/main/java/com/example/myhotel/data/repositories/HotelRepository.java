package com.example.myhotel.data.repositories;

import com.example.myhotel.data.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
