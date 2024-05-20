package com.example.medicalendar.service;

import com.example.medicalendar.model.*;
import com.example.medicalendar.repository.BookingTicketRepository;
import com.example.medicalendar.repository.ServiceRepository;
import com.example.medicalendar.response.TimeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private BookingTicketRepository bookingTicketRepository;

    public TimeResponse getAvailableTime(Long serviceId) {
        TimeResponse response = new TimeResponse();
        Optional<com.example.medicalendar.model.Service> serviceOptional = serviceRepository.findById(serviceId);

        if (serviceOptional.isPresent()) {
            com.example.medicalendar.model.Service service = serviceOptional.get();
            List<Doctor> doctors = service.getDoctorList();

            LocalDate startDate = LocalDate.now();
            LocalDate endDate = startDate.plusDays(30);

            Set<LocalDate> availableDates = new HashSet<>();
            Set<LocalDate> fullyUnavailableDates = new HashSet<>();
            Map<LocalDate, Set<ShiftDuration>> unavailableDurationsByDate = new HashMap<>();
            Set<ShiftDuration> availableShiftDurations = new HashSet<>();

            List<BookingTicket> bookings = bookingTicketRepository.findByServiceAndBookingDateBetween(service, startDate, endDate);

            for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
                DayOfWeek dayOfWeek = date.getDayOfWeek();
                for (Doctor doctor : doctors) {
                    for (DoctorShiftDayEntity shiftDay : doctor.getShiftDays()) {
                        if (convertShiftDayToDayOfWeek(shiftDay.getShiftDay()).equals(dayOfWeek)) {
                            availableDates.add(date);
                            for (DoctorShiftDurationEntity shiftDuration : doctor.getShiftDurations()) {
                                checkAndAddUnavailableDurations(bookings, date, shiftDuration.getShiftDuration(), unavailableDurationsByDate);
                                availableShiftDurations.add(shiftDuration.getShiftDuration());
                            }
                        }
                    }
                }

                if (unavailableDurationsByDate.containsKey(date) && unavailableDurationsByDate.get(date).containsAll(availableShiftDurations)) {
                    fullyUnavailableDates.add(date);
                    availableDates.remove(date);
                }
            }

            // Convert to list and sort
            List<LocalDate> sortedAvailableDates = availableDates.stream()
                    .sorted()
                    .collect(Collectors.toList());

            List<LocalDate> sortedFullyUnavailableDates = fullyUnavailableDates.stream()
                    .sorted()
                    .collect(Collectors.toList());

            List<ShiftDuration> availableShiftDurationsSorted = availableShiftDurations.stream()
                    .sorted()
                    .collect(Collectors.toList());

            response.setAvailableDays(sortedAvailableDates);
            response.setAvailableshiftDurations(availableShiftDurationsSorted);
            response.setUnavailableDurations(unavailableDurationsByDate);
            response.setUnavailableDays(sortedFullyUnavailableDates);
        }

        return response;
    }

    private void checkAndAddUnavailableDurations(List<BookingTicket> bookings, LocalDate date, ShiftDuration shiftDuration, Map<LocalDate, Set<ShiftDuration>> unavailableDurationsByDate) {
        long count = bookings.stream()
                .filter(booking -> booking.getBookingDate().equals(date) && booking.getShiftDuration().equals(shiftDuration))
                .count();

        if (count >= 3) {
            unavailableDurationsByDate.computeIfAbsent(date, k -> new HashSet<>()).add(shiftDuration);
        }
    }

    private DayOfWeek convertShiftDayToDayOfWeek(ShiftDay shiftDay) {
        switch (shiftDay) {
            case MONDAY:
                return DayOfWeek.MONDAY;
            case TUESDAY:
                return DayOfWeek.TUESDAY;
            case WEDNESDAY:
                return DayOfWeek.WEDNESDAY;
            case THURSDAY:
                return DayOfWeek.THURSDAY;
            case FRIDAY:
                return DayOfWeek.FRIDAY;
            case SATURDAY:
                return DayOfWeek.SATURDAY;
            case SUNDAY:
                return DayOfWeek.SUNDAY;
            default:
                throw new IllegalArgumentException("Unknown shift day: " + shiftDay);
        }
    }
}
