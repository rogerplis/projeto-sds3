package com.roger.backend.entitie;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String razao;
    @Valid
    @NotBlank(message = "CNPJ não pode ser vazio")
    @CNPJ(message = "CNPJ invalido")
    private String cnpj;
    @Getter
    @Setter
    private Integer loja;
    @Email
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String website;
    @Getter
    @Setter
    private String tel;
    @Getter
    @Setter
    private String msg;
    @Getter
    @Setter
    private String cep;
    @Getter
    @Setter
    private Integer numero;

    @Getter
    @Setter
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.PERSIST)
    @JoinTable( name = "company_person" ,
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    private List<Person> contato = new ArrayList<>();


    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
