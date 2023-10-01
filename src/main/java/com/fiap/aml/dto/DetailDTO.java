package com.fiap.aml.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fiap.aml.entity.Detail;

public class DetailDTO {

    @JsonIgnore
    private int id;

    private String detailDescription;

    public DetailDTO() {

    }

    public DetailDTO(Detail detail) {
        this.id = detail.getId();
        this.detailDescription = detail.getDetailDescription();
    }

    public DetailDTO(int id, String detailDescription) {
        this.id = id;
        this.detailDescription = detailDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    @Override
    public String toString() {
        return "DetailDTO{" +
                "id=" + id +
                ", detailDescription='" + detailDescription + '\'' +
                '}';
    }
}