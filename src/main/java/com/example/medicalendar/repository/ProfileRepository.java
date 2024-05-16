package com.example.medicalendar.repository;

import com.example.medicalendar.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    boolean existsByIdHealthInsurance(String idHealthInsurance);
    boolean existsByIdNumber(String idNumber);

    @Override
    Optional<Profile> findById(Long aLong);
}