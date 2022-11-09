package com.roger.backend.services.impl;

import com.roger.backend.entitie.Person;
import com.roger.backend.repositories.PersonRepository;
import com.roger.backend.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository repository;

    @Override
    public List<Person> listarTodos() {
        return this.repository.findAll();
    }

    @Override
    public Person cadastrar(Person person) {
        return this.repository.save(person);
    }

    @Override
    public Person atualizar(Person person) {
        return this.repository.save(person);
    }

    public Optional<Person> buscarCpf(String cpf) {
        return this.repository.findByCpf(cpf);
    }

    @Override
    public void deletar(Long id) {
    this.repository.deleteById(id);
    }
}
