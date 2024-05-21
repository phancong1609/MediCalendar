package com.example.medicalendar.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class BookingTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "order_number", nullable = false)
    private int orderNumber;

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    private Service service;

    @Column(name = "price")
    private int price;

    @Column(name = "date_of_booking")
    private LocalDateTime dateOfBooking;

    @Column(name = "bookingDate")
    private LocalDate bookingDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "shift_duration")
    private ShiftDuration shiftDuration ;

    @ManyToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;

    public BookingTicket() {

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDateTime getDateOfBooking() {
        return dateOfBooking;
    }

    public void setDateOfBooking(LocalDateTime dateOfBooking) {
        this.dateOfBooking = dateOfBooking;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public ShiftDuration getShiftDuration() {
        return shiftDuration;
    }

    public void setShiftDuration(ShiftDuration shiftDuration) {
        this.shiftDuration = shiftDuration;
    }

    public BookingTicket(Long id, int orderNumber, Service service, int price, LocalDateTime dateOfBooking, LocalDate bookingDate, ShiftDuration shiftDuration) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.service = service;
        this.price = price;
        this.dateOfBooking = dateOfBooking;
        this.bookingDate = bookingDate;
        this.shiftDuration = shiftDuration;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
