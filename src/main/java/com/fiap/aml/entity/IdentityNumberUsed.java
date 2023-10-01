package com.fiap.aml.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name="identity_number_used")
public class IdentityNumberUsed {

    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "identity_number_used_seq")
    @SequenceGenerator(name = "identity_number_used_seq", sequenceName = "identity_number_used_sequence", allocationSize = 1)
    private int id;

    @Column(name="code")
    private String number;

    @Column(name="type")
    private String type;

    @Column(name="issuing_country")
    private String issuingCountry;

    @ManyToOne
    @JoinColumn(name="wanted_id")
    private Wanted wanted;

    // Constructors
    public IdentityNumberUsed() {

    }

    public IdentityNumberUsed(String number, String type, String issuingCountry, Wanted wanted) {
        this.number = number;
        this.type = type;
        this.issuingCountry = issuingCountry;
        this.wanted = wanted;
    }

    // Getters and Setters
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

    public Wanted getWanted() {
        return wanted;
    }

    public void setWanted(Wanted wanted) {
        this.wanted = wanted;
    }

    // toString()
    @Override
    public String toString() {
        return "IdentityNumberUsed{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", type='" + type + '\'' +
                ", issuingCountry='" + issuingCountry + '\'' +
                '}';
    }
}