package com.example.medicalendar.controller;

import com.example.medicalendar.request.RegisterRequest;
import com.example.medicalendar.response.MessageResponse;
import com.example.medicalendar.response.OfficeResponse;
import com.example.medicalendar.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/office")
public class OfficeController {

    @Autowired
    OfficeService officeService;

    @GetMapping("/all")
    public ResponseEntity<OfficeResponse> getAllOfficeRequest()
    {
        try {
            OfficeResponse response = officeService.getAllOffice();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            OfficeResponse messageResponse = new OfficeResponse(e.getMessage());
            return ResponseEntity.badRequest().body(messageResponse);
        }
    }
}
