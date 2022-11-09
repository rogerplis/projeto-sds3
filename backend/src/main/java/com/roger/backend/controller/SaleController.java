package com.roger.backend.controller;

import com.roger.backend.dto.SaleDTO;
import com.roger.backend.dto.SalerSuccessDTO;
import com.roger.backend.dto.SalerSumDTO;
import com.roger.backend.entitie.Sale;
import com.roger.backend.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api")
public class SaleController {

    @Autowired
    private SaleService service;



    @GetMapping(value = "/sales")
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
        Page<SaleDTO> list = service.findAll(pageable);
        return ResponseEntity.ok(list);
    }
    @GetMapping(value = "/sales/amount-by-seller")
    public ResponseEntity<List<SalerSumDTO>> amountGroupedBySeller() {
        List<SalerSumDTO> list = service.amountGroupedBySeller();
        return ResponseEntity.ok(list);
    }
    @GetMapping(value = "/sales/success-by-seller")
    public ResponseEntity<List<SalerSuccessDTO>> successGroupedBySeller() {
        List<SalerSuccessDTO> list = service.successGroupedBySeller();
        return ResponseEntity.ok(list);
    }
    @GetMapping(value = "/sales/{inicio}&{final}")
    public ResponseEntity<List<SaleDTO>> listarPorData(@PathVariable("inicio")String inicio,
                                                    @PathVariable("final") String fim) {
        LocalDate start = LocalDate.parse(inicio);
        LocalDate end = LocalDate.parse(fim);
        return ResponseEntity.ok(service.listarPorData(start,end));
    }

    @PostMapping(value="/sale")
    public ResponseEntity<Sale> cadastrar(@RequestBody Sale sale){
        return ResponseEntity.ok(this.service.cadastrar(sale));
    }
}
