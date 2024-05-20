package com.example.medicalendar.response;

import com.example.medicalendar.model.ShiftDuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TimeResponse {
    String message;
    List<LocalDate> availableDays ;
    List<ShiftDuration> availableshiftDurations;

    List<LocalDate> unavailableDays;

    public List<LocalDate> getUnavailableDays() {
        return unavailableDays;
    }

    public void setUnavailableDays(List<LocalDate> unavailableDays) {
        this.unavailableDays = unavailableDays;
    }

    Map<LocalDate, Set<ShiftDuration>> unavailableDurations;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<LocalDate> getAvailableDays() {
        return availableDays;
    }

    public void setAvailableDays(List<LocalDate> availableDays) {
        this.availableDays = availableDays;
    }

    public List<ShiftDuration> getAvailableshiftDurations() {
        return availableshiftDurations;
    }

    public void setAvailableshiftDurations(List<ShiftDuration> availableshiftDurations) {
        this.availableshiftDurations = availableshiftDurations;
    }

    public Map<LocalDate, Set<ShiftDuration>> getUnavailableDurations() {
        return unavailableDurations;
    }

    public void setUnavailableDurations(Map<LocalDate, Set<ShiftDuration>> unavailableDurations) {
        this.unavailableDurations = unavailableDurations;
    }
}
