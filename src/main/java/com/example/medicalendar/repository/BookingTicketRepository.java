package com.example.medicalendar.repository;

import com.example.medicalendar.model.BookingTicket;
import com.example.medicalendar.model.Service;
import com.example.medicalendar.model.ShiftDuration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingTicketRepository extends JpaRepository<BookingTicket, Long> {
    List<BookingTicket> findByServiceAndBookingDateAndShiftDuration(Service service, LocalDate bookingDate, ShiftDuration shiftDuration);
    List<BookingTicket> findByBookingDateAndShiftDuration(LocalDate date, ShiftDuration shiftDuration);

    List<BookingTicket> findByServiceAndBookingDateBetween(Service service, LocalDate startDate, LocalDate endDate);
}