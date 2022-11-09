package com.roger.backend.services;

import com.roger.backend.entitie.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    List<Person> listarTodos();
    Person cadastrar(Person person);
    Person atualizar(Person person);
    Optional<Person> buscarCpf(String cpf);
    void deletar(Long id);
}
