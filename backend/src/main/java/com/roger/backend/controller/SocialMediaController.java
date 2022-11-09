package com.roger.backend.controller;

import com.roger.backend.entitie.Person;
import com.roger.backend.entitie.SocialMedia;
import com.roger.backend.services.SocialMediaService;
import com.roger.backend.storage.Disco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api")
public class SocialMediaController {


    @Autowired
    private SocialMediaService service;

    @Autowired
    private Disco disco;


    @RequestMapping(path= "/socialmedia", method = RequestMethod.POST,
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = "application/json")
    public ResponseEntity<Object> saveMediaSocial(@RequestPart SocialMedia socialMedia,
                                                  @RequestParam(value = "file") MultipartFile file) {
        service.cadastrar(socialMedia);
        disco.salvarFoto(file);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/socialmedia")
    public ResponseEntity<List<SocialMedia>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @RequestMapping(path = "/socialmedia/{id}", produces = "application/json", method = RequestMethod.PUT)
    public ResponseEntity<SocialMedia> atualizar(@PathVariable(value = "id") Long id, @RequestBody SocialMedia media) {
        return ResponseEntity.ok(this.service.atualizar(media));
    }

    @RequestMapping(path = "/socialmedia/{name}", method = RequestMethod.GET)
    public ResponseEntity<Optional<SocialMedia>> pesquisarPorNome(@PathVariable(name = "name") String name) {
        return  ResponseEntity.ok(this.service.pesquisarPorNome(name));
    }
    @DeleteMapping("/socialmedia/{id}")
    public ResponseEntity<String> remover(@PathVariable(name = "id") Long id){
        this.service.deletar(id);
        return ResponseEntity.ok("Excluido com sucesso");
    }
}
