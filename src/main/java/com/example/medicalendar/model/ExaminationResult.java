package com.example.medicalendar.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
public class ExaminationResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "prescription")
    private String prescription;

    @Column(name = "diagnose")
    private String diagnose;

    @Column(name = "test")
    private String test;

    @Column(name = "exam_date")
    private LocalDateTime examDate;

    public ExaminationResult() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public LocalDateTime getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDateTime examDate) {
        this.examDate = examDate;
    }

    public ExaminationResult(Long id, String prescription, String diagnose, String test, LocalDateTime examDate) {
        this.id = id;
        this.prescription = prescription;
        this.diagnose = diagnose;
        this.test = test;
        this.examDate = examDate;
    }
}
