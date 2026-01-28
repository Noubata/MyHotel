package com.example.myhotel.data.repositories;

import com.example.myhotel.data.models.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
