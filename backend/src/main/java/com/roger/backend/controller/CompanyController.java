package com.roger.backend.controller;

import com.roger.backend.entitie.Company;
import com.roger.backend.entitie.Person;
import com.roger.backend.services.CompanyService;
import com.roger.backend.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api")
public class CompanyController {
    @Autowired
    private CompanyService service;

    @Autowired
    private PersonService personService;

    @RequestMapping(path = "/empresa", method = RequestMethod.POST )
    public ResponseEntity<Object> cadastrar(@Validated(Company.class) @RequestBody Company company, BindingResult result) {
        if (result.hasErrors()){
            return ResponseEntity.ok(result.getAllErrors());
        }
        service.cadastrar(company);
        return ResponseEntity.ok("Cadastrado com sucesso");

    }
    @GetMapping("/empresas")
    public ResponseEntity<List<Company>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

}
