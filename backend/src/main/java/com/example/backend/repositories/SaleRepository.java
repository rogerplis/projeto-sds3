package com.example.backend.repositories;

import com.example.backend.entitie.Sale;
import com.example.backend.entitie.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
