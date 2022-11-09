package com.roger.backend.services;

import com.roger.backend.entitie.SocialMedia;

import java.util.List;
import java.util.Optional;

public interface SocialMediaService {

    List<SocialMedia> listarTodos();
    SocialMedia cadastrar(SocialMedia socialMedia );
    SocialMedia atualizar(SocialMedia SocialMedia);
    Optional<SocialMedia> pesquisarPorNome(String name);
    void deletar(Long id);
}
