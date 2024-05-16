package com.example.medicalendar.repository;

import com.example.medicalendar.model.MedicalSpeciality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalSpecialityRepository extends JpaRepository<MedicalSpeciality, Long> {
}