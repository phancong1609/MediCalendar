package com.example.medicalendar.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "logo")
    private String logo;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Service> serviceList;

    public Office(Long id, String logo, String name, String address, String description, List<Service> serviceList) {
        this.id = id;
        this.logo = logo;
        this.name = name;
        this.address = address;
        this.description = description;
        this.serviceList = serviceList;
    }

    public Office() {

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

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
