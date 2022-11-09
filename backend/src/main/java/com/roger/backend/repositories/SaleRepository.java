package com.roger.backend.repositories;

import com.roger.backend.dto.SaleDTO;
import com.roger.backend.dto.SalerSuccessDTO;
import com.roger.backend.dto.SalerSumDTO;
import com.roger.backend.entitie.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    //JPQL
    @Query("Select new com.roger.backend.dto.SalerSumDTO(obj.seller, SUM(obj.amount)) " +
            "From Sale as obj GROUP BY obj.seller")
    List<SalerSumDTO> amountGroupedBySeller();

    //JPQL
    @Query("Select new com.roger.backend.dto.SalerSuccessDTO(obj.seller, SUM(obj.visited),SUM(obj.deals) ) " +
            "From Sale as obj GROUP BY obj.seller")
    List<SalerSuccessDTO> successGroupedBySeller();

    List<SaleDTO> findByDateBetween(LocalDate start, LocalDate end);
}
