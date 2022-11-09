package com.roger.backend.services.impl;

import com.roger.backend.entitie.MarkingPoint;
import com.roger.backend.repositories.MarkingPointRepository;
import com.roger.backend.services.MarkingPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MarkingPointServiceImpl implements MarkingPointService {

    @Autowired
    private MarkingPointRepository repository;

    @Override
    public List<MarkingPoint> listarTodos() {
        return this.repository.findAll();
    }

    @Override
    public MarkingPoint cadastrar(MarkingPoint MarkingPoint) {
        return this.repository.save(MarkingPoint);
    }

    @Override
    public MarkingPoint atualizar(MarkingPoint MarkingPoint) {
        return this.repository.save(MarkingPoint);
    }

    public List<MarkingPoint> buscarPis(String pis) {
        return this.repository.findByPis(pis);
    }

    @Override
    public List<MarkingPoint> buscarPisDatas(String pis, LocalDate dtInicio, LocalDate dtFim) {
        return this.repository.findByPisAndDtMarcacaoIsBetween(pis, dtInicio, dtFim);
    }

    @Override
    public void deletar(Long id) {
    this.repository.deleteById(id);
    }
}
