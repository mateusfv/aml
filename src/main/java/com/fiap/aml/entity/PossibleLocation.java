package com.fiap.aml.entity;

import jakarta.persistence.*;

@Entity
@Table(name="possible_location")
public class PossibleLocation {

    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="location")
    private String location;

    @ManyToOne
    @JoinColumn(name="wanted_id")
    private Wanted wanted;

    // Constructors
    public PossibleLocation() {

    }

    public PossibleLocation(String location, Wanted wanted) {
        this.location = location;
        this.wanted = wanted;
    }

    // Getters and Setters
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

    public Wanted getWanted() {
        return wanted;
    }

    public void setWanted(Wanted wanted) {
        this.wanted = wanted;
    }

    // toString()
    @Override
    public String toString() {
        return "PossibleLocation{" +
                "id=" + id +
                ", location='" + location + '\'' +
                '}';
    }
}