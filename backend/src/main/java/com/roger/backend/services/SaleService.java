package com.roger.backend.services;

import com.roger.backend.dto.SaleDTO;
import com.roger.backend.dto.SalerSuccessDTO;
import com.roger.backend.dto.SalerSumDTO;
import com.roger.backend.entitie.Sale;
import com.roger.backend.repositories.SaleRepository;
import com.roger.backend.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    @Autowired
    private SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable) {
        sellerRepository.findAll();
       Page<Sale> result = repository.findAll(pageable);
        return  result.map(SaleDTO::new);
    }

    @Transactional(readOnly = true)
    public List<SalerSumDTO> amountGroupedBySeller(){
        return repository.amountGroupedBySeller();
    }

    @Transactional(readOnly = true)
    public List<SalerSuccessDTO> successGroupedBySeller(){
        return repository.successGroupedBySeller();
    }

    public Sale cadastrar(Sale sale) {
        return this.repository.save(sale);
    }

    public List<SaleDTO> listarPorData(LocalDate start, LocalDate end){
        return  repository.findByDateBetween(start, end);
    }
}
