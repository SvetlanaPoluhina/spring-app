package com.example.servingwebcontent.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "analysis")
public class Analysis {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long idanalysis;

    private String name_analysis;
    private String date_analysis;
    private String result;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User patient;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "admin_id")
    private User admin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "place_id")
    private Place policlinic;

    public Analysis() {
    }

    public Analysis(String name_analysis, User user, User admin, Place policlinic, String date_analysis, String result) {
        this.patient = user;
        this.name_analysis = name_analysis;
        this.admin = admin;
        this.policlinic = policlinic;
        this.date_analysis = date_analysis;
        this.result = result;
    }

    public String getPoliclinicName() {
        return policlinic!= null ? policlinic.getAddress() : "Не указано";
    }

    public String getPatientName() {
        return patient!= null ? patient.getUsername() : "Не указано";
    }

    public String getAdminName() {
        return admin!= null ? admin.getLastname() : "Не указано";
    }

    public User getPatient() {
        return patient;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }

    public Long getIdanalysis() {
        return idanalysis;
    }

    public void setIdanalysis(Long idanalysis) {
        this.idanalysis = idanalysis;
    }

    public String getName_analysis() {
        return name_analysis!= null ? name_analysis : "Не указано";
    }

    public void setName_analysis(String name_analysis) {
        this.name_analysis = name_analysis;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public String getDate_analysis() {
        return date_analysis!= null ? date_analysis : "Не указано";
    }

    public void setDate_analysis(String date_analysis) {
        this.date_analysis = date_analysis;
    }

    public String getResult() {
        return result!= null ? result : "Не указано";
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Place getPoliclinic() {
        return policlinic;
    }

    public void setPoliclinic(Place policlinic) {
        this.policlinic = policlinic;
    }
}
