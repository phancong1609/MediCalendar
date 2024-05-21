package com.example.medicalendar.service;

import com.example.medicalendar.model.*;
import com.example.medicalendar.repository.BookingTicketRepository;
import com.example.medicalendar.repository.PatientRepository;
import com.example.medicalendar.repository.ProfileRepository;
import com.example.medicalendar.repository.ServiceRepository;
import com.example.medicalendar.request.BookTicketRequest;
import com.example.medicalendar.response.TimeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    private BookingTicketRepository bookingTicketRepository;
    @Autowired
    private ProfileRepository profileRepository;

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

    public List<String> getUnavailableDays(Long serviceId) {
        Optional<com.example.medicalendar.model.Service> serviceOptional = serviceRepository.findById(serviceId);

        if (serviceOptional.isPresent()) {
            com.example.medicalendar.model.Service service = serviceOptional.get();
            List<Doctor> doctors = service.getDoctorList();

            LocalDate startDate = LocalDate.now();
            LocalDate endDate = startDate.plusDays(30);

            Set<LocalDate> fullyUnavailableDates = new HashSet<>();
            Set<LocalDate> nonWorkingDates = new HashSet<>();
            Set<ShiftDuration> availableShiftDurations = new HashSet<>();
            Map<LocalDate, Set<ShiftDuration>> unavailableDurationsByDate = new HashMap<>();

            List<BookingTicket> bookings = bookingTicketRepository.findByServiceAndBookingDateBetween(service, startDate, endDate);

            // Iterate over each day in the date range
            for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
                DayOfWeek dayOfWeek = date.getDayOfWeek();
                boolean anyDoctorWorking = false;

                // Iterate over each doctor
                for (Doctor doctor : doctors) {
                    // Check if the doctor works on this day
                    boolean doctorWorksToday = false;
                    for (DoctorShiftDayEntity shiftDay : doctor.getShiftDays()) {
                        if (convertShiftDayToDayOfWeek(shiftDay.getShiftDay()).equals(dayOfWeek)) {
                            doctorWorksToday = true;
                            anyDoctorWorking = true;
                            // Check each shift duration for this doctor
                            for (DoctorShiftDurationEntity shiftDuration : doctor.getShiftDurations()) {
                                checkAndAddUnavailableDurations(bookings, date, shiftDuration.getShiftDuration(), unavailableDurationsByDate);
                                availableShiftDurations.add(shiftDuration.getShiftDuration());
                            }
                        }
                    }
                    // If no doctors work on this day, add to non-working days
                    if (!doctorWorksToday) {
                        nonWorkingDates.add(date);
                    }
                }

                // If no doctors work on this day, mark the day as fully unavailable
                if (!anyDoctorWorking) {
                    fullyUnavailableDates.add(date);
                } else if (unavailableDurationsByDate.containsKey(date) && unavailableDurationsByDate.get(date).containsAll(availableShiftDurations)) {
                    fullyUnavailableDates.add(date);
                }
            }

            // Combine non-working days and fully unavailable dates
            fullyUnavailableDates.addAll(nonWorkingDates);

            return fullyUnavailableDates.stream()
                    .sorted()
                    .map(LocalDate::toString)
                    .collect(Collectors.toList());
        }

        return Collections.emptyList();
    }

    public List<ShiftDuration> getAvailableDurationsOfDate(Long serviceId, LocalDate date) {
        Optional<com.example.medicalendar.model.Service> serviceOptional = serviceRepository.findById(serviceId);

        if (serviceOptional.isPresent()) {
            com.example.medicalendar.model.Service service = serviceOptional.get();
            List<Doctor> doctors = service.getDoctorList();

            Set<ShiftDuration> availableShiftDurations = new HashSet<>();
            Map<LocalDate, Set<ShiftDuration>> unavailableDurationsByDate = new HashMap<>();

            List<BookingTicket> bookings = bookingTicketRepository.findByServiceAndBookingDateBetween(service, date, date);

            DayOfWeek dayOfWeek = date.getDayOfWeek();
            for (Doctor doctor : doctors) {
                for (DoctorShiftDayEntity shiftDay : doctor.getShiftDays()) {
                    if (convertShiftDayToDayOfWeek(shiftDay.getShiftDay()).equals(dayOfWeek)) {
                        for (DoctorShiftDurationEntity shiftDuration : doctor.getShiftDurations()) {
                            checkAndAddUnavailableDurations(bookings, date, shiftDuration.getShiftDuration(), unavailableDurationsByDate);
                            availableShiftDurations.add(shiftDuration.getShiftDuration());
                        }
                    }
                }
            }

            Set<ShiftDuration> unavailableDurations = unavailableDurationsByDate.getOrDefault(date, Collections.emptySet());
            List<ShiftDuration> availableDurations = availableShiftDurations.stream()
                    .filter(duration -> !unavailableDurations.contains(duration))
                    .sorted()
                    .collect(Collectors.toList());

            return availableDurations;
        }

        return Collections.emptyList();
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

    public BookingTicket bookTicket(BookTicketRequest request) {
        System.out.println("a");
        Optional<com.example.medicalendar.model.Service> serviceOptional = serviceRepository.findById(request.getServiceId());
        if (serviceOptional.isPresent()) {
            Patient patientOptional = patientRepository.findByEmail(request.getPatientEmail());
            if (patientOptional != null) {
                Optional<Profile> profileOptional = profileRepository.findById(request.getProfileId());
                if (profileOptional.isPresent()) {
                    Profile profile = profileOptional.get();
                    BookingTicket bookingTicket = new BookingTicket();
                    bookingTicket.setOrderNumber(generateOrderNumber());
                    bookingTicket.setService(serviceOptional.get());
                    bookingTicket.setPrice(300);
                    bookingTicket.setDateOfBooking(LocalDateTime.now());
                    bookingTicket.setBookingDate(LocalDate.parse(request.getBookingDate()));
                    bookingTicket.setShiftDuration(request.getShiftDuration());
                    bookingTicket.setProfile(profile);

                    BookingTicket savedTicket = bookingTicketRepository.save(bookingTicket);

                    patientOptional.getTicketList().add(savedTicket);
                    patientRepository.save(patientOptional);

                    return savedTicket;
                }
            }
        }
        return null;
    }

    private int generateOrderNumber() {
        return (int) (Math.random() * 100000);
    }
}
