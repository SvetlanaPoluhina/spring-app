package com.example.servingwebcontent.domain;

import javax.persistence.*;

@Entity
@Table(name = "sick_leave")
public class SickLeave {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id_sick_leave;

    private String date_sick;
    private String ogrn;
    private String place_work;
    private String start_sick;
    private String end_sick;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id_sick")
    private User patient_sick;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "admin_id_sick")
    private User doctor_sick;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "place_id_sick")
    private Place policlinic_sick;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_code_sick")
    private SickLeaveCode code_sick;

    public String getCodeName() {
        return code_sick!= null ? code_sick.getValue_code() : "Не указано";
    }

    public SickLeave(){}

    public SickLeave(User patient_sick, User doctor_sick, Place policlinic_sick, String date_sick,
                     String ogrn, String place_work, String start_sick, String end_sick, SickLeaveCode code_sick) {
        this.patient_sick = patient_sick;
        this.doctor_sick = doctor_sick;
        this.policlinic_sick = policlinic_sick;
        this.date_sick = date_sick;
        this.ogrn = ogrn;
        this.place_work = place_work;
        this.start_sick = start_sick;
        this.end_sick = end_sick;
        this.code_sick = code_sick;
    }

    public String getPoliclinic_sickName() {
        return policlinic_sick!= null ? policlinic_sick.getAddress() : "Не указано";
    }

    public String getPatient_sickName() {
        return patient_sick!= null ? patient_sick.getLastname() + ' ' + patient_sick.getFirstname() + ' ' + patient_sick.getPatronymic() : "Не указано";
    }

    public String getPatient_sickBirthday() {
        return patient_sick!= null ? patient_sick.getBirthday() : "Не указано";
    }

    public String getDoctor_sickName() {
        return doctor_sick!= null ? doctor_sick.getLastname() + ' ' + doctor_sick.getFirstname() + ' ' + doctor_sick.getPatronymic() : "Не указано";
    }

    public Long getId_sick_leave() {
        return id_sick_leave;
    }

    public void setId_sick_leave(Long id_sick_leave) {
        this.id_sick_leave = id_sick_leave;
    }

    public String getDate_sick() {
        return date_sick;
    }

    public void setDate_sick(String date_sick) {
        this.date_sick = date_sick;
    }

    public String getOgrn() {
        return ogrn;
    }

    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    public String getPlace_work() {
        return place_work;
    }

    public void setPlace_work(String place_work) {
        this.place_work = place_work;
    }

    public String getStart_sick() {
        return start_sick;
    }

    public void setStart_sick(String start_sick) {
        this.start_sick = start_sick;
    }

    public String getEnd_sick() {
        return end_sick;
    }

    public void setEnd_sick(String end_sick) {
        this.end_sick = end_sick;
    }

    public User getPatient_sick() {
        return patient_sick;
    }

    public void setPatient_sick(User patient_sick) {
        this.patient_sick = patient_sick;
    }

    public User getDoctor_sick() {
        return doctor_sick;
    }

    public void setDoctor_sick(User doctor_sick) {
        this.doctor_sick = doctor_sick;
    }

    public Place getPoliclinic_sick() {
        return policlinic_sick;
    }

    public void setPoliclinic_sick(Place policlinic_sick) {
        this.policlinic_sick = policlinic_sick;
    }

    public SickLeaveCode getCode_sick() {
        return code_sick;
    }

    public void setCode_sick(SickLeaveCode code_sick) {
        this.code_sick = code_sick;
    }
}
