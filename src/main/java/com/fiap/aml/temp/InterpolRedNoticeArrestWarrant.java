package com.fiap.aml.temp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InterpolRedNoticeArrestWarrant {

    private String charge;

    @JsonProperty("issuing_country_id")
    private String issuingCountryId;

    @JsonProperty("charge_translation")
    private String chargeTranslation;

    // Constructors
    public InterpolRedNoticeArrestWarrant() {

    }

    public InterpolRedNoticeArrestWarrant(String charge, String issuingCountryId, String chargeTranslation) {
        this.charge = charge;
        this.issuingCountryId = issuingCountryId;
        this.chargeTranslation = chargeTranslation;
    }

    // Getters and Setters
    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getIssuingCountryId() {
        return issuingCountryId;
    }

    public void setIssuingCountryId(String issuingCountryId) {
        this.issuingCountryId = issuingCountryId;
    }

    public String getChargeTranslation() {
        return chargeTranslation;
    }

    public void setChargeTranslation(String chargeTranslation) {
        this.chargeTranslation = chargeTranslation;
    }

    // toString()
    @Override
    public String toString() {
        return "InterpolRedNoticeArrestWarrant{" +
                "charge='" + charge + '\'' +
                ", issuingCountryId='" + issuingCountryId + '\'' +
                ", chargeTranslation='" + chargeTranslation + '\'' +
                '}';
    }
}