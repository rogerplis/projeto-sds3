package com.roger.backend.entitie;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class PersonSocialMedia implements Serializable {

    public static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "social_id")
    private SocialMedia socialMedia;

    private  String link;

    public PersonSocialMedia() {
    }

    public PersonSocialMedia(Long id, Person person, SocialMedia socialMedia, String link) {
        this.id = id;
        this.person = person;
        this.socialMedia = socialMedia;
        this.link = link;
    }
}
