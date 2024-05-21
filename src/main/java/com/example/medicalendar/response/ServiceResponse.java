package com.example.medicalendar.response;

import com.example.medicalendar.dtos.DoctorDTO;

import java.util.List;

public class ServiceResponse {
    private Long id;
    private String name;
    private String serviceType;
    private String description;
    private int remind;
    private List<DoctorDTO> doctors;

    public ServiceResponse() {
    }

    public ServiceResponse(Long id, String name, String serviceType, String description, int remind, List<DoctorDTO> doctors) {
        this.id = id;
        this.name = name;
        this.serviceType = serviceType;
        this.description = description;
        this.remind = remind;
        this.doctors = doctors;
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

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRemind() {
        return remind;
    }

    public void setRemind(int remind) {
        this.remind = remind;
    }

    public List<DoctorDTO> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<DoctorDTO> doctors) {
        this.doctors = doctors;
    }
}
