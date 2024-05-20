package com.example.medicalendar.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "doctor")
    private List<DoctorShiftDayEntity> shiftDays;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "doctor")
    private List<DoctorShiftDurationEntity> shiftDurations;

    public List<DoctorShiftDayEntity> getShiftDays() {
        return shiftDays;
    }

    public void setShiftDays(List<DoctorShiftDayEntity> shiftDays) {
        this.shiftDays = shiftDays;
    }

    public List<DoctorShiftDurationEntity> getShiftDurations() {
        return shiftDurations;
    }

    public void setShiftDurations(List<DoctorShiftDurationEntity> shiftDurations) {
        this.shiftDurations = shiftDurations;
    }



    public Doctor() {

    }

    public Doctor(Long id, String name, String gender, int bookingPrice, MedicalSpeciality speciality, List<DoctorShiftDayEntity>  shiftDays, List<DoctorShiftDurationEntity> shiftDurations) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.bookingPrice = bookingPrice;
        this.speciality = speciality;
        this.shiftDays = shiftDays;
        this.shiftDurations = shiftDurations;
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
