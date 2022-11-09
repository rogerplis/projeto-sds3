package com.roger.backend.services.impl;

import com.roger.backend.entitie.Company;
import com.roger.backend.repositories.CompanyRepository;
import com.roger.backend.services.CompanyService;
import com.roger.backend.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository repository;

    @Override
    public List<Company> listarTodos() {
        return this.repository.findAll();
    }

    @Override
    public Company cadastrar(Company company) {
        return this.repository.save(company);
    }

    @Override
    public Company atualizar(Company company) {
        return this.repository.save(company);
    }

    public Optional<Company> buscarEmpresa(String cnpj) {
        return this.repository.findByCnpj(cnpj);
    }

    @Override
    public void deletar(Long id) {
    this.repository.deleteById(id);
    }
}
