package com.example.medicalendar.model;

import jakarta.persistence.*;
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "booking_price")
    private int bookingPrice;

    @ManyToOne
    @JoinColumn(name = "speciality_id", nullable = false)
    private MedicalSpeciality speciality;

    @Enumerated(EnumType.STRING)
    @Column(name = "shift_day")
    private ShiftDay shiftDay;

    @Enumerated(EnumType.STRING)
    @Column(name = "shift_duration")
    private ShiftDuration shiftDuration;

    public Doctor() {

    }

    public Doctor(Long id, String name, String gender, int bookingPrice, MedicalSpeciality speciality, ShiftDay shiftDay, ShiftDuration shiftDuration) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.bookingPrice = bookingPrice;
        this.speciality = speciality;
        this.shiftDay = shiftDay;
        this.shiftDuration = shiftDuration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getBookingPrice() {
        return bookingPrice;
    }

    public void setBookingPrice(int bookingPrice) {
        this.bookingPrice = bookingPrice;
    }

    public MedicalSpeciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(MedicalSpeciality speciality) {
        this.speciality = speciality;
    }
}
