package com.example.medicalendar.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "register_date", nullable = false)
    private LocalDateTime registerDate;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Profile> profileList;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Notification> notificationList;

    @OneToMany(cascade = CascadeType.ALL)
    private List<BookingTicket> ticketList;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ExaminationResult> resultList;

    public Patient() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public List<Profile> getProfileList() {
        return profileList;
    }

    public void setProfileList(List<Profile> profileList) {
        this.profileList = profileList;
    }

    public List<Notification> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(List<Notification> notificationList) {
        this.notificationList = notificationList;
    }

    public List<BookingTicket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<BookingTicket> ticketList) {
        this.ticketList = ticketList;
    }

    public List<ExaminationResult> getResultList() {
        return resultList;
    }

    public void setResultList(List<ExaminationResult> resultList) {
        this.resultList = resultList;
    }

    public Patient(Long id, String email, String password, LocalDateTime registerDate, List<Profile> profileList, List<Notification> notificationList, List<BookingTicket> ticketList, List<ExaminationResult> resultList) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.registerDate = registerDate;
        this.profileList = profileList;
        this.notificationList = notificationList;
        this.ticketList = ticketList;
        this.resultList = resultList;
    }
}
