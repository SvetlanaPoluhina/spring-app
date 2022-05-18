package com.example.servingwebcontent.domain;

import javax.persistence.*;
import java.sql.Time;


@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id_schedule;

    private Time start_work;
    private Time end_work;
    private Integer interval;
    private String day_week;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor_shed;

    public Schedule(){
    }

    public Schedule(Time start_work,Time end_work, Integer interval, String day_week, Doctor doctor_shed){
        this.start_work = start_work;
        this.end_work = end_work;
        this.interval = interval;
        this.day_week = day_week;
        this.doctor_shed = doctor_shed;
    }

    public Long getId_schedule() {
        return id_schedule;
    }

    public void setId_schedule(Long id_schedule) {
        this.id_schedule = id_schedule;
    }

    public Time getStart_work() {
        return start_work;
    }

    public void setStart_work(Time start_work) {
        this.start_work = start_work;
    }

    public Time getEnd_work() {
        return end_work;
    }

    public void setEnd_work(Time end_work) {
        this.end_work = end_work;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public String getDay_week() {
        return day_week;
    }

    public void setDay_week(String day_week) {
        this.day_week = day_week;
    }

    public Doctor getDoctor_shed() {
        return doctor_shed;
    }

    public void setDoctor_shed(Doctor doctor_shed) {
        this.doctor_shed = doctor_shed;
    }
}
