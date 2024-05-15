package com.example.medicalendar.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    String content;
    String notificationType;
    LocalDateTime noticedTime;

    public Notification() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public LocalDateTime getNoticedTime() {
        return noticedTime;
    }

    public void setNoticedTime(LocalDateTime noticedTime) {
        this.noticedTime = noticedTime;
    }

    public Notification(Long id, String content, String notificationType, LocalDateTime noticedTime) {
        this.id = id;
        this.content = content;
        this.notificationType = notificationType;
        this.noticedTime = noticedTime;
    }
}
