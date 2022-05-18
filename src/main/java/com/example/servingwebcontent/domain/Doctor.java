package com.example.servingwebcontent.domain;

import javax.persistence.*;
import javax.print.Doc;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id_doctor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user_doc")
    private User user_doctor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_policlinic")
    private Place policlinic_doc;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_spec")
    private Specialization specialization_doc;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Appointment> appointments;

    public Doctor(){
    }

    public Doctor(User user_doctor, Place policlinic_doc, Specialization specialization_doc){
        this.user_doctor = user_doctor;
        this.policlinic_doc = policlinic_doc;
        this.specialization_doc = specialization_doc;
    }

    public Long getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(Long id_doctor) {
        this.id_doctor = id_doctor;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public User getUser_doctor() {
        return user_doctor;
    }

    public void setUser_doctor(User user_doctor) {
        this.user_doctor = user_doctor;
    }

    public Place getPoliclinic_doc() {
        return policlinic_doc;
    }

    public void setPoliclinic_doc(Place policlinic_doc) {
        this.policlinic_doc = policlinic_doc;
    }

    public Specialization getSpecialization_doc() {
        return specialization_doc;
    }

    public void setSpecialization_doc(Specialization specialization_doc) {
        this.specialization_doc = specialization_doc;
    }

}
