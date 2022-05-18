package com.example.servingwebcontent.domain;

import javax.persistence.*;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id_appointment;

    private String date_app;
    private LocalTime start_app;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_app_id")
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_app_id")
    private User patient_app;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_status_app")
    private StatusAppoint status_appointment;

    public String getStatusAppName() {
        return status_appointment!= null ? status_appointment.getApp_status() : "Не указано";
    }

    public Appointment(){
    }

    public Appointment(String date_app, LocalTime start_app, Doctor doctor, User patient_app, StatusAppoint status_appointment){
        this.date_app = date_app;
        this.start_app = start_app;
        this.doctor = doctor;
        this.patient_app = patient_app;
        this.status_appointment = status_appointment;
    }

    public Long getId_appointment() {
        return id_appointment;
    }

    public void setId_appointment(Long id_appointment) {
        this.id_appointment = id_appointment;
    }

    public String getDate_app() {
        return date_app;
    }

    public void setDate_app(String date_app) {
        this.date_app = date_app;
    }

    public LocalTime getStart_app() {
        return start_app;
    }

    public void setStart_app(LocalTime start_app) {
        this.start_app = start_app;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public User getPatient_app() {
        return patient_app;
    }

    public void setPatient_app(User patient_app) {
        this.patient_app = patient_app;
    }

    public StatusAppoint getStatus_appointment() {
        return status_appointment;
    }

    public void setStatus_appointment(StatusAppoint status_appointment) {
        this.status_appointment = status_appointment;
    }



}
