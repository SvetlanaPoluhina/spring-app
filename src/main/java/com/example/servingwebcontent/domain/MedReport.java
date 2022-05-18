package com.example.servingwebcontent.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "medical_report")
public class MedReport {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id_med_report;

    private String date_report;
    private String complaint;
    private String treatment;
    private String date_repeated_admission;
    private String diagnoses;
    private String researches;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id_rep")
    private User patient_rep;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "admin_id_rep")
    private User doctor_rep;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "place_id_rep")
    private Place policlinic_rep;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_status_report")
    private StatusReport status_report;

    public String getStatusName() {
        return status_report!= null ? status_report.getStatus() : "Не указано";
    }

    public MedReport(){
    }

    public MedReport(User patient_rep, User doctor_rep, Place policlinic_rep, String date_report,
                     String complaint, String treatment, String date_repeated_admission, StatusReport status_report,
                     String diagnoses, String researches) {
        this.patient_rep = patient_rep;
        this.doctor_rep = doctor_rep;
        this.policlinic_rep = policlinic_rep;
        this.date_report = date_report;
        this.complaint = complaint;
        this.treatment = treatment;
        this.date_repeated_admission = date_repeated_admission;
        this.status_report = status_report;
        this.diagnoses = diagnoses;
        this.researches = researches;
    }

    public String getPoliclinic_repName() {
        return policlinic_rep!= null ? policlinic_rep.getAddress() : "Не указано";
    }

    public String getPatient_repName() {
        return patient_rep!= null ? patient_rep.getLastname() + ' ' + patient_rep.getFirstname() + ' ' + patient_rep.getPatronymic() : "Не указано";
    }

    public String getDoctor_repName() {
        return doctor_rep!= null ? doctor_rep.getLastname() + ' ' + doctor_rep.getFirstname() + ' ' + doctor_rep.getPatronymic() : "Не указано";
    }

    public Long getId_med_report() {
        return id_med_report;
    }

    public void setId_med_report(Long id_med_report) {
        this.id_med_report = id_med_report;
    }

    public String getDate_report() {
        return date_report;
    }

    public void setDate_report(String date_report) {
        this.date_report = date_report;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getDate_repeated_admission() {
        return date_repeated_admission;
    }

    public void setDate_repeated_admission(String date_repeated_admission) {
        this.date_repeated_admission = date_repeated_admission;
    }

    public User getPatient_rep() {
        return patient_rep;
    }

    public void setPatient_rep(User patient_rep) {
        this.patient_rep = patient_rep;
    }

    public User getDoctor_rep() {
        return doctor_rep;
    }

    public void setDoctor_rep(User doctor_rep) {
        this.doctor_rep = doctor_rep;
    }

    public Place getPoliclinic_rep() {
        return policlinic_rep;
    }

    public void setPoliclinic_rep(Place policlinic_rep) {
        this.policlinic_rep = policlinic_rep;
    }

    public StatusReport getStatus_report() {
        return status_report;
    }

    public void setStatus_report(StatusReport status_report) {
        this.status_report = status_report;
    }

    public String getDiagnoses() { return diagnoses; }

    public void setDiagnoses(String diagnoses) { this.diagnoses = diagnoses; }

    public String getResearches() {
        return researches;
    }

    public void setResearches(String researches) {
        this.researches = researches;
    }
}
