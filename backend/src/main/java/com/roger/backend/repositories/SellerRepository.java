package com.roger.backend.repositories;

import com.roger.backend.entitie.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
