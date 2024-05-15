package com.example.medicalendar.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
public class BookingTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "order_number", nullable = false)
    private int orderNumber;

    @OneToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @Column(name = "price")
    private int price;

    @Column(name = "booking_date")
    private LocalDateTime bookingDate;

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

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }


    public BookingTicket(Long id, int orderNumber, Service service, int price, LocalDateTime bookingDate) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.service = service;
        this.price = price;
        this.bookingDate = bookingDate;
    }
}
