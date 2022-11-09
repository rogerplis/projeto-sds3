package com.roger.backend.dto;

public class PersonSocialMediaDTO {

    private Long id;

    private int person;

    private int socialMedia;

    private  String link;

    public PersonSocialMediaDTO() {
    }

    public PersonSocialMediaDTO(Long id, int person, int socialMedia, String link) {
        this.id = id;
        this.person = person;
        this.socialMedia = socialMedia;
        this.link = link;
    }

    public PersonSocialMediaDTO(int person, int socialMedia, String link) {
        this.person = person;
        this.socialMedia = socialMedia;
        this.link = link;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }

    public int getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(int socialMedia) {
        this.socialMedia = socialMedia;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
