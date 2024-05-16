package com.example.medicalendar.service;

import com.example.medicalendar.model.Patient;
import com.example.medicalendar.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;
    public void register(String email, String pass, String repPass) throws Exception {
        Patient existingPatient = patientRepository.findByEmail(email);
        if (existingPatient != null) {
            throw new Exception("Patient already exists");
        }

        if (!pass.equals(repPass)) {
            throw new Exception("Passwords does not match");
        }

        Patient newPatient = new Patient();
        newPatient.setEmail(email);
        newPatient.setPassword(pass);

        patientRepository.save(newPatient);
    }

    public void login(String email, String pass) throws Exception {
        Patient p = patientRepository.findByEmail(email);
        if (p == null) {
            throw new Exception("Patient does not exist ");
        }

        if (!p.getPassword().equals(pass)) {
            throw new Exception("Wrong password");
        }
    }

}
