package com.example.medicalendar.controller;

import com.example.medicalendar.request.LoginRequest;
import com.example.medicalendar.request.RegisterRequest;
import com.example.medicalendar.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService patientService;

    @PostMapping("/register")
    public ResponseEntity<String> registerRequest(@RequestBody RegisterRequest request)
    {
        try {
            patientService.register(request.getEmail(), request.getPassword(), request.getRepeatpassword());
            return ResponseEntity.ok("Register Successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        try{
            patientService.login(email, password);
            return ResponseEntity.ok("Login Succesfully");
        } catch (Exception e) {
            return ResponseEntity.status(401).build();
        }
    }
}
