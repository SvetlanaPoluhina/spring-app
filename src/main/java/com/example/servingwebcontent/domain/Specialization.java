package com.example.servingwebcontent.domain;

import javax.persistence.*;

@Entity
@Table(name = "specialization")
public class Specialization {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id_specialization;

    private String name_spec;

    public Specialization(){
    }

    public Specialization(String name_spec){
        this.name_spec = name_spec;
    }

    public Long getId_specialization() {
        return id_specialization;
    }

    public void setId_specialization(Long id_specialization) {
        this.id_specialization = id_specialization;
    }

    public String getName_spec() {
        return name_spec;
    }

    public void setName_spec(String name_spec) {
        this.name_spec = name_spec;
    }
}
