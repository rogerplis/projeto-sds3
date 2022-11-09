package com.roger.backend.services;

import com.roger.backend.entitie.Company;
import com.roger.backend.entitie.Person;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

    List<Company> listarTodos();
    Company cadastrar(Company company);
    Company atualizar(Company company);
    Optional<Company> buscarEmpresa(String cnpj);
    void deletar(Long id);
}
