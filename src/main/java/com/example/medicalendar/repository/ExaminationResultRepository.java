package com.example.medicalendar.repository;

import com.example.medicalendar.model.ExaminationResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExaminationResultRepository extends JpaRepository<ExaminationResult, Long> {
}