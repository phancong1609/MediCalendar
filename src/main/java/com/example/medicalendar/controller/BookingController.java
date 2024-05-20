package com.example.medicalendar.controller;

import com.example.medicalendar.model.Profile;
import com.example.medicalendar.request.EditProfileRequest;
import com.example.medicalendar.response.MessageResponse;
import com.example.medicalendar.response.TimeResponse;
import com.example.medicalendar.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    BookingService bookingService;
    @GetMapping("/available/{serviceid}")
    public ResponseEntity<TimeResponse> getAvailableTimeRequest(@PathVariable Long service_id){
        try {
            TimeResponse response = bookingService.getAvailableTime(service_id);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            TimeResponse messageResponse = new TimeResponse();
            messageResponse.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(messageResponse);
        }
    }
}
