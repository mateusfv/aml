package com.fiap.aml.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fiap.aml.entity.IdentityNumberUsed;

public class IdentityNumberUsedDTO {

    @JsonIgnore
    private int id;

    private String number;

    private String type;

    private String issuingCountry;

    public IdentityNumberUsedDTO() {

    }

    public IdentityNumberUsedDTO(IdentityNumberUsed identityNumberUsed) {
        this.id = identityNumberUsed.getId();
        this.number = identityNumberUsed.getNumber();
        this.type = identityNumberUsed.getType();
        this.issuingCountry = identityNumberUsed.getIssuingCountry();
    }

    public IdentityNumberUsedDTO(int id, String number, String type, String issuingCountry) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.issuingCountry = issuingCountry;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIssuingCountry() {
        return issuingCountry;
    }

    public void setIssuingCountry(String issuingCountry) {
        this.issuingCountry = issuingCountry;
    }

    @Override
    public String toString() {
        return "IdentityNumberUsedDTO{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", type='" + type + '\'' +
                ", issuingCountry='" + issuingCountry + '\'' +
                '}';
    }
}