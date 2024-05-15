package com.example.medicalendar.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;

    public Service() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    private String description;

    @Column(name = "remind")
    private int remind;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Doctor> doctorList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setServiceType(ServiceType serviceType) {
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

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    public Service(Long id, String name, ServiceType serviceType, String description, int remind, List<Doctor> doctorList) {
        this.id = id;
        this.name = name;
        this.serviceType = serviceType;
        this.description = description;
        this.remind = remind;
        this.doctorList = doctorList;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

}
