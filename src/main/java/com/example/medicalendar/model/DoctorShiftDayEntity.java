package com.example.medicalendar.model;

import jakarta.persistence.*;

@Entity
public class DoctorShiftDayEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "shift_day")
    private ShiftDay shiftDay;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    public DoctorShiftDayEntity(Long id, ShiftDay shiftDay, Doctor doctor) {
        this.id = id;
        this.shiftDay = shiftDay;
        this.doctor = doctor;
    }

    public DoctorShiftDayEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShiftDay getShiftDay() {
        return shiftDay;
    }

    public void setShiftDay(ShiftDay shiftDay) {
        this.shiftDay = shiftDay;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
