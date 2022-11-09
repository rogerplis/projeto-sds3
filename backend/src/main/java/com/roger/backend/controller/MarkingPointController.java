package com.roger.backend.controller;

import com.roger.backend.dto.SaleDTO;
import com.roger.backend.entitie.MarkingPoint;
import com.roger.backend.services.MarkingPointService;
import com.roger.backend.storage.Disco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api")
public class MarkingPointController {
    //formato da hora vindo do txt e transformando em objeto date com formatação em ingles
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy")
            .withLocale(Locale.FRANCE);

    @Autowired
    private Disco disco;

    @Autowired
    private MarkingPointService service;

    @Autowired
    private PasswordEncoder encryptor;

    @RequestMapping(path= "/marking", method = RequestMethod.POST,
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = "application/json")
    public ResponseEntity<Object> saveMarking(@RequestParam(value = "file")MultipartFile file) throws IOException {
        String nameFile = file.getOriginalFilename();
        disco.salvarMarcacao(file);
       List<String> marcacoes = disco.abrirArquivo(nameFile);

       for (String marcacao : marcacoes ) {
            String nsr = marcacao.substring(0, 10);
            String data = marcacao.substring(10, 18);
            String hour = marcacao.substring(18, 20);
            String min = marcacao.substring(20, 22);
            String pis = marcacao.substring(23, 34);
            String time = hour + ':' + min;
            LocalTime hm = LocalTime.parse(time, DateTimeFormatter.ISO_LOCAL_TIME).truncatedTo(ChronoUnit.SECONDS);
            LocalDate data2 = LocalDate.parse(data, formatter);
            String pisEncripty = encryptor.encode(pis);
           MarkingPoint markingPoint = new MarkingPoint();
           markingPoint.setNsr(nsr);
           markingPoint.setDtMarcacao(data2);
           markingPoint.setHrMarcacao(hm);
           markingPoint.setPis(pisEncripty);
           service.cadastrar(markingPoint);
        }
        return ResponseEntity.ok("Marcaçoes cadastrada com sucesso");

    }

    @GetMapping(value = "/marking/{pis}&{inicio}&{final}")
    public ResponseEntity<List<MarkingPoint>> listarPorData(@PathVariable("pis")String pis,
            @PathVariable("inicio")String inicio, @PathVariable("final") String fim) {
        LocalDate start = LocalDate.parse(inicio, formatter);
        LocalDate end = LocalDate.parse(fim,formatter);
        return ResponseEntity.ok(service.buscarPisDatas(pis,start,end));
    }
}
