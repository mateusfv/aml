package com.fiap.aml.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fiap.aml.entity.Nationality;
import jakarta.persistence.Column;

public class NationalityDTO {

    @JsonIgnore
    private int id;

    private String country;

    private String codeAlpha2;

    private String codeAlpha3;

    private String gentilic;

    public NationalityDTO() {

    }

    public NationalityDTO(Nationality nationality) {
        this.id = nationality.getId();
        this.country = nationality.getCountry();
        this.codeAlpha2 = nationality.getCodeAlpha2();
        this.codeAlpha3 = nationality.getCodeAlpha3();
        this.gentilic = nationality.getGentilic();
    }

    public NationalityDTO(int id, String country, String codeAlpha2, String codeAlpha3, String gentilic) {
        this.id = id;
        this.country = country;
        this.codeAlpha2 = codeAlpha2;
        this.codeAlpha3 = codeAlpha3;
        this.gentilic = gentilic;
    }

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

    @Override
    public String toString() {
        return "NationalityDTO{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", codeAlpha2='" + codeAlpha2 + '\'' +
                ", codeAlpha3='" + codeAlpha3 + '\'' +
                ", gentilic='" + gentilic + '\'' +
                '}';
    }
}