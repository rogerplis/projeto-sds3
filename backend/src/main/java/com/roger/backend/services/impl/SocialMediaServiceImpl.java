package com.roger.backend.services.impl;

import com.roger.backend.entitie.SocialMedia;
import com.roger.backend.repositories.SocialMediaRepository;
import com.roger.backend.services.SocialMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SocialMediaServiceImpl implements SocialMediaService {

    @Autowired
    private SocialMediaRepository repository;

    @Override
    public List<SocialMedia> listarTodos() {
        return this.repository.findAll();
    }

    @Override
    public SocialMedia cadastrar(SocialMedia socialMedia) {
        return this.repository.save(socialMedia);
    }

    @Override
    public SocialMedia atualizar(SocialMedia socialMedia) {
        return this.repository.save(socialMedia);
    }

    @Override
    public Optional<SocialMedia> pesquisarPorNome(String name) {
        return this.repository.findByNameContaining(name);
    }

    @Override
    public void deletar(Long id) {
    this.repository.deleteById(id);
    }
}
