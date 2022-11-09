package com.roger.backend.repositories;

import com.roger.backend.dto.PersonSocialMediaDTO;
import com.roger.backend.entitie.Person;
import com.roger.backend.entitie.PersonSocialMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonSocialMediaRepository extends JpaRepository<PersonSocialMedia, Long> {
    Optional<PersonSocialMedia> findByLink(String link);
    Boolean existsByLink(String link);
}
