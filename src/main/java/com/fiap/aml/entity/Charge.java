package com.fiap.aml.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name="charge")
public class Charge {

    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "charge_seq")
    @SequenceGenerator(name = "charge_seq", sequenceName = "charge_sequence", allocationSize = 1)
    private int id;

    @Column(name="charge_description", columnDefinition="CLOB") //Change to "TEXT" for MySQL
    private String chargeDescription;

    @Column(name="issuing_country")
    private String issuingCountry;

    @ManyToOne
    @JoinColumn(name="wanted_id")
    private Wanted wanted;

    // Constructors
    public Charge() {

    }

    public Charge(String chargeDescription, String issuingCountry, Wanted wanted) {
        this.chargeDescription = chargeDescription;
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

    public String getChargeDescription() {
        return chargeDescription;
    }

    public void setChargeDescription(String chargeDescription) {
        this.chargeDescription = chargeDescription;
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
        return "Charge{" +
                "id=" + id +
                ", chargeDescription='" + chargeDescription + '\'' +
                ", issuingCountry='" + issuingCountry + '\'' +
                '}';
    }
}