package com.fiap.aml.entity;

import jakarta.persistence.*;

@Entity
@Table(name="date_of_birth_declared")
public class DateOfBirthDeclared {

    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
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