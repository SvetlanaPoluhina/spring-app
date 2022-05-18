package com.example.servingwebcontent.domain;

import javax.persistence.*;

@Entity
@Table(name = "vaccine")
public class Vaccine {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idvaccine;

    private String name_vaccine;
    private String name_preparate;
    private String date;
    private String dose_vaccine;
    private String country_vaccine;
    private String result_tuberdiagnoz;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User patient_vac;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "admin_id")
    private User admin_vac;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "place_id")
    private Place poliklinik;

    public Vaccine(){
    }

    public Vaccine(String name_vaccine, User patient_vac, User admin_vac, Place poliklinik, String name_preparate, String date, String dose_vaccine,
                   String country_vaccine, String result_tuberdiagnoz){
        this.name_vaccine = name_vaccine;
        this.patient_vac = patient_vac;
        this.admin_vac = admin_vac;
        this.poliklinik = poliklinik;
        this.name_preparate = name_preparate;
        this.date = date;
        this.dose_vaccine = dose_vaccine;
        this.country_vaccine = country_vaccine;
        this.result_tuberdiagnoz = result_tuberdiagnoz;
    }

    public String getPoliklinikName() {
        return poliklinik!= null ? poliklinik.getAddress() : "Не указано";
    }

    public String getPatient_vacName() {
        return patient_vac != null ? patient_vac.getUsername() : "Не указано";
    }

    public String getAdmin_vacName() {
        return admin_vac != null ? admin_vac.getLastname() : "Не указано";
    }

    public Long getIdvaccine() {
        return idvaccine;
    }

    public void setIdvaccine(Long idvaccine) {
        this.idvaccine = idvaccine;
    }

    public String getName_vaccine() {
        return name_vaccine!= null ? name_vaccine : "Не указано";
    }

    public void setName_vaccine(String name_vaccine) {
        this.name_vaccine = name_vaccine;
    }

    public User getPatient_vac() {
        return patient_vac;
    }

    public void setPatient_vac(User patient_vac) {
        this.patient_vac = patient_vac;
    }

    public User getAdmin_vac() {
        return admin_vac;
    }

    public void setAdmin_vac(User admin_vac) {
        this.admin_vac = admin_vac;
    }

    public String getDate() {
        return date!= null ? date : "Не указано";
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDose_vaccine() {
        return dose_vaccine!= null ? dose_vaccine : "Не указано";
    }

    public void setDose_vaccine(String dose_vaccine) {
        this.dose_vaccine = dose_vaccine;
    }

    public String getCountry_vaccine() {
        return country_vaccine!= null ? country_vaccine : "Не указано";
    }

    public void setCountry_vaccine(String country_vaccine) {
        this.country_vaccine = country_vaccine;
    }

    public String getResult_tuberdiagnoz() {
        return result_tuberdiagnoz!= null ? result_tuberdiagnoz : "Не указано";
    }

    public void setResult_tuberdiagnoz(String result_tuberdiagnoz) {
        this.result_tuberdiagnoz = result_tuberdiagnoz;
    }

    public String getName_preparate() {
        return name_preparate!= null ? name_preparate : "Не указано";
    }

    public void setName_preparate(String name_preparate) {
        this.name_preparate = name_preparate;
    }

    public Place getPoliklinik() {
        return poliklinik;
    }

    public void setPoliklinik(Place poliklinik) {
        this.poliklinik = poliklinik;
    }
}
