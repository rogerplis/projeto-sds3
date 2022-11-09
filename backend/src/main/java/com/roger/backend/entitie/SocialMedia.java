package com.roger.backend.entitie;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class SocialMedia implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String icon;

    @JsonIgnore
    @OneToMany(mappedBy = "socialMedia")
    List<PersonSocialMedia> socialMediaSet;

    public SocialMedia() {
    }

    public SocialMedia(Long id, String name, String icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
    }


}
