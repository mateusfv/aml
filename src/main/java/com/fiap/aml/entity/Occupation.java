package com.fiap.aml.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name="occupation")
public class Occupation {

    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "occupation_seq")
    @SequenceGenerator(name = "occupation_seq", sequenceName = "occupation_sequence", allocationSize = 1)
    private int id;

    @Column(name="description", columnDefinition="CLOB") //Change to "TEXT" for MySQL
    private String description;

    @ManyToOne
    @JoinColumn(name="wanted_id")
    private Wanted wanted;

    // Constructors
    public Occupation() {

    }

    public Occupation(String description, Wanted wanted) {
        this.description = description;
        this.wanted = wanted;
    }

    // Getters and Setters
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

    public Wanted getWanted() {
        return wanted;
    }

    public void setWanted(Wanted wanted) {
        this.wanted = wanted;
    }

    // toString()
    @Override
    public String toString() {
        return "Occupation{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}