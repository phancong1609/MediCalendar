package com.example.medicalendar.dtos;

public class DoctorDTO {
    private Long id;
    private String name;
    private String gender;
    private int bookingPrice;
    private Long specialityId;

    public DoctorDTO() {
    }

    public DoctorDTO(Long id, String name, String gender, int bookingPrice, Long specialityId) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.bookingPrice = bookingPrice;
        this.specialityId = specialityId;
    }

    // Getters and Setters
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

    public Long getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(Long specialityId) {
        this.specialityId = specialityId;
    }
}
