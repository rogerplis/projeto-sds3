package com.roger.backend.entitie;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
public class MarkingPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pis;
    private String nsr;
    private LocalDate dtMarcacao;
    private LocalTime hrMarcacao;


    public MarkingPoint(Long id, String pis, String nsr, LocalDate dtMarcacao, LocalTime hrMarcacao) {
        this.id = id;
        this.pis = pis;
        this.nsr = nsr;
        this.dtMarcacao = dtMarcacao;
        this.hrMarcacao = hrMarcacao;
    }

    public MarkingPoint() {

    }

    public MarkingPoint(String nsr, LocalDate dtMarcacao, LocalTime hrMarcacao, String pis) {
    }
}
