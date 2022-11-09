package com.roger.backend.repositories;

import com.roger.backend.entitie.SocialMedia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SocialMediaRepository extends JpaRepository<SocialMedia, Long> {

    Optional<SocialMedia> findByNameContaining(String name);
}
