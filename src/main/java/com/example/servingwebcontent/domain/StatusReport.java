package com.example.servingwebcontent.domain;

import javax.persistence.*;

@Entity
@Table(name = "status_report")
public class StatusReport {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id_status_report;

    private String status;

    public StatusReport(){
    }

    public StatusReport(String status){
        this.status = status;
    }

    public Long getId_status_report() {
        return id_status_report;
    }

    public void setId_status_report(Long id_status_report) {
        this.id_status_report = id_status_report;
    }

    public String getStatus() {
        return status!= null ? status : "Не указано";
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
