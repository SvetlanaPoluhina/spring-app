package com.example.servingwebcontent.domain;

import javax.persistence.*;

@Entity
@Table(name = "sick_leave_code")
public class SickLeaveCode {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id_code;

    private String value_code;
    private String descript_code;

    public SickLeaveCode(){}

    public Long getId_code() {
        return id_code;
    }

    public void setId_code(Long id_code) {
        this.id_code = id_code;
    }

    public String getValue_code() {
        return value_code;
    }

    public void setValue_code(String value_code) {
        this.value_code = value_code;
    }

    public String getDescript_code() {
        return descript_code;
    }

    public void setDescript_code(String descript_code) {
        this.descript_code = descript_code;
    }
}
