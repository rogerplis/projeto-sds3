package com.example.backend.services;

import com.example.backend.dto.SellerDTO;
import com.example.backend.entitie.Seller;
import com.example.backend.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {

    @Autowired
    private SellerRepository repository;

    public List<SellerDTO> findAll() {
        List<Seller> result = repository.findAll();
        return  result.stream().map(SellerDTO::new).collect(Collectors.toList());
    }
}
