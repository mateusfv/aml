package com.fiap.aml.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fiap.aml.entity.LanguageSpoken;

public class LanguageSpokenDTO {

    @JsonIgnore
    private int id;

    private String alphaId;

    private String language;

    public LanguageSpokenDTO() {

    }

    public LanguageSpokenDTO(LanguageSpoken languageSpoken) {
        this.id = languageSpoken.getId();
        this.alphaId = languageSpoken.getAlphaId();
        this.language = languageSpoken.getLanguage();
    }

    public LanguageSpokenDTO(int id, String alphaId, String language) {
        this.id = id;
        this.alphaId = alphaId;
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlphaId() {
        return alphaId;
    }

    public void setAlphaId(String alphaId) {
        this.alphaId = alphaId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "LanguageSpokenDTO{" +
                "id=" + id +
                ", alphaId='" + alphaId + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}