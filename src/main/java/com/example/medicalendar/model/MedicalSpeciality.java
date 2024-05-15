package com.example.medicalendar.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class MedicalSpeciality {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    public MedicalSpeciality() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public MedicalSpeciality(Long id, String name, String description, Set<Doctor> doctors) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

}
