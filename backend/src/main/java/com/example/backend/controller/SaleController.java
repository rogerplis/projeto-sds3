package com.example.backend.controller;

import com.example.backend.dto.SaleDTO;
import com.example.backend.dto.SalerSuccessDTO;
import com.example.backend.dto.SalerSumDTO;
import com.example.backend.repositories.SellerRepository;
import com.example.backend.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService service;



    @GetMapping
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
        Page<SaleDTO> list = service.findAll(pageable);
        return ResponseEntity.ok(list);
    }
    @GetMapping(value = "/amount-by-seller")
    public ResponseEntity<List<SalerSumDTO>> amountGroupedBySeller() {
        List<SalerSumDTO> list = service.amountGroupedBySeller();
        return ResponseEntity.ok(list);
    }
    @GetMapping(value = "/success-by-seller")
    public ResponseEntity<List<SalerSuccessDTO>> successGroupedBySeller() {
        List<SalerSuccessDTO> list = service.successGroupedBySeller();
        return ResponseEntity.ok(list);
    }
}
