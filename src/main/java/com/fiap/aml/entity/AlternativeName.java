package com.fiap.aml.entity;

import jakarta.persistence.*;

@Entity
@Table(name="alternative_name")
public class AlternativeName {

    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alternative_name_seq")
    @SequenceGenerator(name = "alternative_name_seq", sequenceName = "alternative_name_sequence", allocationSize = 1)
    private int id;

    @Column(name="alias")
    private String alias;

    @ManyToOne
    @JoinColumn(name="wanted_id")
    private Wanted wanted;

    // Constructors
    public AlternativeName() {

    }

    public AlternativeName(String alias, Wanted wanted) {
        this.alias = alias;
        this.wanted = wanted;
    }

    // Getters and Setters
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

    public Wanted getWanted() {
        return wanted;
    }

    public void setWanted(Wanted wanted) {
        this.wanted = wanted;
    }

    // toString()
    @Override
    public String toString() {
        return "AlternativeName{" +
                "id=" + id +
                ", alias='" + alias + '\'' +
                '}';
    }
}