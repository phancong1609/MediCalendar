package com.example.medicalendar.model;

import jakarta.persistence.*;

@Entity
public class DoctorShiftDurationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "shift_duration")
    private ShiftDuration shiftDuration;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    public DoctorShiftDurationEntity(Long id, ShiftDuration shiftDuration, Doctor doctor) {
        this.id = id;
        this.shiftDuration = shiftDuration;
        this.doctor = doctor;
    }

    public DoctorShiftDurationEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShiftDuration getShiftDuration() {
        return shiftDuration;
    }

    public void setShiftDuration(ShiftDuration shiftDuration) {
        this.shiftDuration = shiftDuration;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
