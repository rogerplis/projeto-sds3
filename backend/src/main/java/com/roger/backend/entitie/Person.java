package com.roger.backend.entitie;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Person implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cep;
    private Integer numero;
    @CPF(message = "CPF incorreto")
    private String cpf;
    private String email;
    private String cel;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "person")
    private List<PersonSocialMedia> socialLink;

    private LocalDate birthdate;

    public Person() {
    }

    public Person(Long id, String name, String cep, Integer numero, String cpf, String email, String cel, List<PersonSocialMedia> socialLink, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.cep = cep;
        this.numero = numero;
        this.cpf = cpf;
        this.email = email;
        this.cel = cel;
        this.socialLink = socialLink;
        this.birthdate = birthdate;
    }
}
