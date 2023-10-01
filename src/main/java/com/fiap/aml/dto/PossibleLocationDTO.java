package com.fiap.aml.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fiap.aml.entity.PossibleLocation;

public class PossibleLocationDTO {

    @JsonIgnore
    private int id;

    private String location;

    public PossibleLocationDTO() {

    }

    public PossibleLocationDTO(PossibleLocation possibleLocation) {
        this.id = possibleLocation.getId();
        this.location = possibleLocation.getLocation();
    }

    public PossibleLocationDTO(int id, String location) {
        this.id = id;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "PossibleLocationDTO{" +
                "id=" + id +
                ", location='" + location + '\'' +
                '}';
    }
}