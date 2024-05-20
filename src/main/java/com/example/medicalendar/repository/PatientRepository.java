package com.example.medicalendar.repository;

import com.example.medicalendar.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByEmail(String email);


    @Override
    Optional<Patient> findById(Long aLong);
}