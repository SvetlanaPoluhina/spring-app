package com.example.servingwebcontent.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "diagnosis")
public class Diagnosis {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id_diagnoses;

    private String name_diag;

    public Diagnosis(){
    }

    public Diagnosis(String name_diag){
        this.name_diag = name_diag;
    }

    public Long getId_diagnoses() {
        return id_diagnoses;
    }

    public void setId_diagnoses(Long id_diagnoses) {
        this.id_diagnoses = id_diagnoses;
    }

    public String getName_diag() {
        return name_diag;
    }

    public void setName_diag(String name_diag) {
        this.name_diag = name_diag;
    }

}
