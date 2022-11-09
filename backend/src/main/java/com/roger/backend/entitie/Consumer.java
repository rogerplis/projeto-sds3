package com.roger.backend.entitie;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Consumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private char tipo;
    @OneToOne
    private Company company;
    @OneToOne
    private Person person;
    private String billingCep;
    private String deliveryCep;
    private String contato;
}
