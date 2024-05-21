package com.example.medicalendar.controller;

import com.example.medicalendar.model.BookingTicket;
import com.example.medicalendar.model.Profile;
import com.example.medicalendar.model.ShiftDuration;
import com.example.medicalendar.request.BookTicketRequest;
import com.example.medicalendar.request.EditProfileRequest;
import com.example.medicalendar.response.MessageResponse;
import com.example.medicalendar.response.TimeResponse;
import com.example.medicalendar.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    BookingService bookingService;
    @GetMapping("/available/{serviceid}")
    public ResponseEntity<TimeResponse> getAvailableTimeRequest(@PathVariable("serviceid") Long serviceId){
        try {
            System.out.println(serviceId);
            TimeResponse response = bookingService.getAvailableTime(serviceId);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            TimeResponse messageResponse = new TimeResponse();
            messageResponse.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(messageResponse);
        }
    }



    @GetMapping("/unavailable/{serviceid}")
    public ResponseEntity<List<String>> getUnavailableDays(@PathVariable("serviceid") Long serviceId) {
        try {
            List<String> response = bookingService.getUnavailableDays(serviceId);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/availableDurations/{serviceid}/{date}")
    public ResponseEntity<List<ShiftDuration>> getAvailableDurationsOfDate(
            @PathVariable("serviceid") Long serviceId,
            @PathVariable("date") String dateString) {
        try {
            LocalDate date = LocalDate.parse(dateString);
            List<ShiftDuration> response = bookingService.getAvailableDurationsOfDate(serviceId, date);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/book")
    public ResponseEntity<MessageResponse> bookTicket(@RequestBody BookTicketRequest request) {
        try {
            BookingTicket bookingTicket = bookingService.bookTicket(request);
            if (bookingTicket != null) {
                return ResponseEntity.ok(new MessageResponse("Booking successful"));
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("Booking failed"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse(e.getMessage()));
        }
    }
}
