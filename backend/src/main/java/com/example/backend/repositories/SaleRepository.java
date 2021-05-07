package com.example.backend.repositories;

import com.example.backend.dto.SalerSuccessDTO;
import com.example.backend.dto.SalerSumDTO;
import com.example.backend.entitie.Sale;
import com.example.backend.entitie.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    //JPQL
    @Query("Select new com.example.backend.dto.SalerSumDTO(obj.seller, SUM(obj.amount)) " +
            "From Sale as obj GROUP BY obj.seller")
    List<SalerSumDTO> amountGroupedBySeller();

    //JPQL
    @Query("Select new com.example.backend.dto.SalerSuccessDTO(obj.seller, SUM(obj.visited),SUM(obj.deals) ) " +
            "From Sale as obj GROUP BY obj.seller")
    List<SalerSuccessDTO> successGroupedBySeller();
}
