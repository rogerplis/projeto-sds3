package com.roger.backend.entitie;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class ContactCompany implements Serializable {
    public static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String workEmail;
    private String workTel;
    private boolean active;
    private String jobeRole;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public ContactCompany() {
    }

    public ContactCompany(Long id, String workEmail, String workTel, boolean active, Person person, Company company) {
        this.id = id;
        this.workEmail = workEmail;
        this.workTel = workTel;
        this.active = active;
        this.person = person;
        this.company = company;
    }
}
