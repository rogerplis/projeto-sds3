package com.roger.backend.repositories;

import com.roger.backend.entitie.MarkingPoint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MarkingPointRepository extends JpaRepository<MarkingPoint, Long> {

    List<MarkingPoint> findByPis(String pis);
    Boolean existsByNsr(String nsr);
    List<MarkingPoint> findByPisAndDtMarcacaoIsBetween(String pis, LocalDate dtIncio, LocalDate dtFim);
}
