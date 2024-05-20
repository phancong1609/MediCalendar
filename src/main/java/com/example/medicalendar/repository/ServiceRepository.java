package com.example.medicalendar.repository;

import com.example.medicalendar.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    @Override
    Optional<Service> findById(Long aLong);
}