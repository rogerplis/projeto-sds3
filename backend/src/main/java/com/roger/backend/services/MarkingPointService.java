package com.roger.backend.services;

import com.roger.backend.entitie.MarkingPoint;

import java.time.LocalDate;
import java.util.List;

public interface MarkingPointService {

    List<MarkingPoint> listarTodos();
    MarkingPoint cadastrar(MarkingPoint point);
    MarkingPoint atualizar(MarkingPoint point);
    List<MarkingPoint> buscarPis(String pis);
    List<MarkingPoint> buscarPisDatas(String pis, LocalDate dtInicio,LocalDate dtFim );
    void deletar(Long id);
}
