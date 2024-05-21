package com.example.medicalendar.dtos;

import com.example.medicalendar.model.ServiceType;

import java.util.List;

public class OfficeDTO {
    private Long id;
    private String logo;
    private String name;
    private String address;
    private String description;
    private List<ServiceType> serviceTypes;

    public OfficeDTO(Long id, String logo, String name, String address, String description, List<ServiceType> serviceTypes) {
        this.id = id;
        this.logo = logo;
        this.name = name;
        this.address = address;
        this.description = description;
        this.serviceTypes = serviceTypes;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ServiceType> getServiceTypes() {
        return serviceTypes;
    }

    public void setServiceTypes(List<ServiceType> serviceTypes) {
        this.serviceTypes = serviceTypes;
    }
}
