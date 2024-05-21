package com.example.medicalendar.request;

import com.example.medicalendar.model.ShiftDuration;

import java.time.LocalDate;

public class BookTicketRequest {
    private Long profileId;
    private String bookingDate;
    private ShiftDuration shiftDuration;
    private Long serviceId;
    private String patientEmail;

    // Getters and Setters
    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public ShiftDuration getShiftDuration() {
        return shiftDuration;
    }

    public void setShiftDuration(ShiftDuration shiftDuration) {
        this.shiftDuration = shiftDuration;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }
}