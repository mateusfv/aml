package com.fiap.aml.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fiap.aml.entity.Occupation;

public class OccupationDTO {

    @JsonIgnore
    private int id;

    private String description;

    public OccupationDTO() {

    }

    public OccupationDTO(Occupation occupation) {
        this.id = occupation.getId();
        this.description = occupation.getDescription();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "OccupationDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}