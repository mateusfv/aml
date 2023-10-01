package com.fiap.aml.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="language_spoken")
public class LanguageSpoken {

    // Fields
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="alpha_id")
    private String alphaId;

    @Column(name="language")
    private String language;

    @ManyToMany(mappedBy = "languagesSpoken")
    private Set<Wanted> wanteds = new HashSet<>();

    // Constructors
    public LanguageSpoken() {

    }

    public LanguageSpoken(String alphaId, String language, Set<Wanted> wanteds) {
        this.alphaId = alphaId;
        this.language = language;
        this.wanteds = wanteds;
    }

    // Getters and Setters
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

    @JsonBackReference
    public Set<Wanted> getWanteds() {
        return wanteds;
    }

    public void setWanteds(Set<Wanted> wanteds) {
        this.wanteds = wanteds;
    }

    // toString()
    @Override
    public String toString() {
        return "LanguageSpoken{" +
                "id=" + id +
                ", alphaId='" + alphaId + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}