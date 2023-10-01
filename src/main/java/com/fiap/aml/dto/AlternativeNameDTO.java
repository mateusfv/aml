package com.fiap.aml.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fiap.aml.entity.AlternativeName;

public class AlternativeNameDTO {

    @JsonIgnore
    private int id;

    private String alias;

    public AlternativeNameDTO() {

    }

    public AlternativeNameDTO(AlternativeName alternativeName) {
        this.id = alternativeName.getId();
        this.alias = alternativeName.getAlias();
    }

    public AlternativeNameDTO(int id, String alias) {
        this.id = id;
        this.alias = alias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public String toString() {
        return "AlternativeNameDTO{" +
                "id=" + id +
                ", alias='" + alias + '\'' +
                '}';
    }
}