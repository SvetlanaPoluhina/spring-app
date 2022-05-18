package com.example.servingwebcontent.domain;

import javax.persistence.*;

@Entity
@Table(name = "app_status")
public class StatusAppoint {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id_app_status;

    private String app_status;

    public StatusAppoint(){
    }

    public StatusAppoint(String app_status){
        this.app_status = app_status;
    }

    public Long getId_app_status() {
        return id_app_status;
    }

    public void setId_app_status(Long id_app_status) {
        this.id_app_status = id_app_status;
    }

    public String getApp_status() {
        return app_status!= null ? app_status : "Не указано";
    }

    public void setApp_status(String app_status) {
        this.app_status = app_status;
    }
}
