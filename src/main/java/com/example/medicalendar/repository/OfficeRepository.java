package com.example.medicalendar.repository;

import com.example.medicalendar.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepository extends JpaRepository<Office, Long> {
}