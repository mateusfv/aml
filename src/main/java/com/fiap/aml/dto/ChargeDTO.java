package com.fiap.aml.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fiap.aml.entity.Charge;

public class ChargeDTO {

    @JsonIgnore
    private int id;

    private String chargeDescription;

    private String issuingCountry;

    public ChargeDTO() {

    }

    public ChargeDTO(Charge charge) {
        this.id = charge.getId();
        this.chargeDescription = charge.getChargeDescription();
        this.issuingCountry = charge.getIssuingCountry();
    }

    public ChargeDTO(int id, String chargeDescription, String issuingCountry) {
        this.id = id;
        this.chargeDescription = chargeDescription;
        this.issuingCountry = issuingCountry;
    }

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

    @Override
    public String toString() {
        return "ChargeDTO{" +
                "id=" + id +
                ", chargeDescription='" + chargeDescription + '\'' +
                ", issuingCountry='" + issuingCountry + '\'' +
                '}';
    }
}