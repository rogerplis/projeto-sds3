package com.roger.backend.repositories;

import com.roger.backend.entitie.Company;
import com.roger.backend.entitie.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findByCnpj(String cnpj);
    Boolean existsByCnpj(String cnpj);
}
