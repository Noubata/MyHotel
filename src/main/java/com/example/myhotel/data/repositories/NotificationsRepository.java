package com.example.myhotel.data.repositories;

import com.example.myhotel.data.models.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationsRepository extends JpaRepository<Notifications, Long> {
}
