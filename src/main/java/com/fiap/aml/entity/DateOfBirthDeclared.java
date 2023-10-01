package com.fiap.aml.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name="date_of_birth_declared")
public class DateOfBirthDeclared {

    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "date_of_birth_declared_seq")
    @SequenceGenerator(name = "date_of_birth_declared_seq", sequenceName = "date_of_birth_declared_sequence", allocationSize = 1)
    private int id;

    @Column(name="date_of_birth")
    private String dateOfBirth;

    @ManyToOne
    @JoinColumn(name="wanted_id")
    private Wanted wanted;

    // Constructors
    public DateOfBirthDeclared() {

    }

    public DateOfBirthDeclared(String dateOfBirth, Wanted wanted) {
        this.dateOfBirth = dateOfBirth;
        this.wanted = wanted;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @JsonBackReference
    public Wanted getWanted() {
        return wanted;
    }

    public void setWanted(Wanted wanted) {
        this.wanted = wanted;
    }

    // toString()
    @Override
    public String toString() {
        return "DateOfBirthDeclared{" +
                "id=" + id +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}