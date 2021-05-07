package com.example.backend.services;

import com.example.backend.dto.SaleDTO;
import com.example.backend.dto.SalerSuccessDTO;
import com.example.backend.dto.SalerSumDTO;
import com.example.backend.entitie.Sale;
import com.example.backend.repositories.SaleRepository;
import com.example.backend.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
