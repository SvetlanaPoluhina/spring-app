package com.example.servingwebcontent.domain;

import javax.persistence.*;

@Entity
@Table(name = "research")
public class Research {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id_research;

    private String name_research;

    public Research(){
    }

    public Research(String name_research){
        this.name_research = name_research;
    }

    public Long getId_research() {
        return id_research;
    }

    public void setId_research(Long id_research) {
        this.id_research = id_research;
    }

    public String getName_research() {
        return name_research;
    }

    public void setName_research(String name_research) {
        this.name_research = name_research;
    }
}
