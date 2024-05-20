package com.example.medicalendar.controller;

import com.example.medicalendar.request.LoginRequest;
import com.example.medicalendar.request.RegisterRequest;
import com.example.medicalendar.response.MessageResponse;
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
    public ResponseEntity<MessageResponse> registerRequest(@RequestBody RegisterRequest request)
    {
        try {
            patientService.register(request.getEmail(), request.getPassword(), request.getRepeatpassword());
            MessageResponse response = new MessageResponse("Register Successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            MessageResponse messageResponse = new MessageResponse(e.getMessage());
            return ResponseEntity.badRequest().body(messageResponse);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<MessageResponse> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        try{
            patientService.login(email, password);
            MessageResponse response = new MessageResponse("Login Successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            MessageResponse messageResponse = new MessageResponse(e.getMessage());
            return ResponseEntity.badRequest().body(messageResponse);
        }
    }
}
