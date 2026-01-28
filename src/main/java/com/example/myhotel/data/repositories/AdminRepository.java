package com.example.myhotel.data.repositories;

import com.example.myhotel.data.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
