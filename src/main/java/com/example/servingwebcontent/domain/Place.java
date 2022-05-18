package com.example.servingwebcontent.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "place")
public class Place {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idplace;

    private String address;

    public Place() {
    }

    public Place(String address) {
        this.address = address;
    }

    public Long getIdplace() {
        return idplace;
    }

    public void setIdplace(Long idplace) {
        this.idplace = idplace;
    }

    public String getAddress() {
        return address!= null ? address : "Не указано";
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
