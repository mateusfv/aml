package com.fiap.aml.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="nationality")
public class Nationality {

    // Fields
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="country")
    private String country;

    @Column(name="code_alpha2")
    private String codeAlpha2;

    @Column(name="code_alpha3")
    private String codeAlpha3;

    @Column(name="gentilic")
    private String gentilic;

    @ManyToMany(mappedBy = "nationalities")
    private Set<Wanted> wanteds = new HashSet<>();

    // Constructors
    public Nationality() {

    }

    public Nationality(String country, String codeAlpha2, String codeAlpha3, String gentilic, Set<Wanted> wanteds) {
        this.country = country;
        this.codeAlpha2 = codeAlpha2;
        this.codeAlpha3 = codeAlpha3;
        this.gentilic = gentilic;
        this.wanteds = wanteds;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCodeAlpha2() {
        return codeAlpha2;
    }

    public void setCodeAlpha2(String codeAlpha2) {
        this.codeAlpha2 = codeAlpha2;
    }

    public String getCodeAlpha3() {
        return codeAlpha3;
    }

    public void setCodeAlpha3(String codeAlpha3) {
        this.codeAlpha3 = codeAlpha3;
    }

    public String getGentilic() {
        return gentilic;
    }

    public void setGentilic(String gentilic) {
        this.gentilic = gentilic;
    }

    public Set<Wanted> getWanteds() {
        return wanteds;
    }

    public void setWanteds(Set<Wanted> wanteds) {
        this.wanteds = wanteds;
    }

    // toString()
    @Override
    public String toString() {
        return "Nationality{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", codeAlpha2='" + codeAlpha2 + '\'' +
                ", codeAlpha3='" + codeAlpha3 + '\'' +
                ", gentilic='" + gentilic + '\'' +
                '}';
    }
}