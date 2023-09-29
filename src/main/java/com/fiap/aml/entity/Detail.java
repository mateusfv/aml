package com.fiap.aml.entity;

import jakarta.persistence.*;

@Entity
@Table(name="detail")
public class Detail {

    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="detail_description", columnDefinition="TEXT") //ToDo change to CLOB
    private String detailDescription;

    @ManyToOne
    @JoinColumn(name="wanted_id")
    private Wanted wanted;

    // Constructors
    public Detail() {

    }

    public Detail(String detailDescription, Wanted wanted) {
        this.detailDescription = detailDescription;
        this.wanted = wanted;
    }

    // Getters and Setters
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

    public Wanted getWanted() {
        return wanted;
    }

    public void setWanted(Wanted wanted) {
        this.wanted = wanted;
    }

    // toString()
    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", detailDescription='" + detailDescription + '\'' +
                '}';
    }
}