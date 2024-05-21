package com.example.medicalendar.repository;

import com.example.medicalendar.model.Patient;
import com.example.medicalendar.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Profile findProfileById(Long id);
    Patient findByEmail(String email);


    @Override
    Optional<Patient> findById(Long aLong);
}