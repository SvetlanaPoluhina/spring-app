package com.example.servingwebcontent.domain;

import javax.persistence.*;

@Entity
@Table(name = "group_blood")
public class GroupBlood {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id_group_blood;

    private String bloodtype;

    public GroupBlood(){
    }

    public GroupBlood(String bloodtype){
        this.bloodtype = bloodtype;
    }

    public Long getId_group_blood() {
        return id_group_blood;
    }

    public void setId_group_blood(Long id_group_blood) {
        this.id_group_blood = id_group_blood;
    }

    public String getBloodtype() {
        return bloodtype!= null ? bloodtype : "Не указано";
    }

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }
}
