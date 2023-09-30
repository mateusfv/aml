package com.fiap.aml.converter;

import com.fiap.aml.dao.LanguageSpokenDAO;
import com.fiap.aml.dao.NationalityDAO;
import com.fiap.aml.entity.Charge;
import com.fiap.aml.entity.LanguageSpoken;
import com.fiap.aml.entity.Nationality;
import com.fiap.aml.entity.Wanted;
import com.fiap.aml.temp.InterpolRedNotice;
import com.fiap.aml.temp.InterpolRedNoticeArrestWarrant;

import java.time.Year;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InterpolToAmlConverter {

    // Fields
    private InterpolRedNotice interpolRedNotice;
    private Wanted wanted;
    private NationalityDAO nationalityDAO;
    private LanguageSpokenDAO languageSpokenDAO;
    private Set<Nationality> nationalities;
    private Set<LanguageSpoken> languagesSpoken;
    private List<Charge> charges;

    // Constructor
    public InterpolToAmlConverter(InterpolRedNotice interpolRedNotice, NationalityDAO nationalityDAO, LanguageSpokenDAO languageSpokenDAO) {
        this.interpolRedNotice = interpolRedNotice;
        this.nationalityDAO = nationalityDAO;
        this.languageSpokenDAO = languageSpokenDAO;
    }

    // Converter
    public Wanted getWanted() {
        this.wanted = new Wanted();
        this.nationalities = new HashSet<>();
        this.languagesSpoken = new HashSet<>();

        if (interpolRedNotice.getForename() != null) {
            this.wanted.setNameTitle(interpolRedNotice.getForename().toUpperCase().trim());
        }

        if (interpolRedNotice.getName() != null) {
            String tempName;
            if (this.wanted.getNameTitle() != null) {
                tempName = this.wanted.getNameTitle() + " " + interpolRedNotice.getName().toUpperCase().trim();
            } else {
                tempName = interpolRedNotice.getName().toUpperCase().trim();
            }
            this.wanted.setNameTitle(tempName);
        }

        this.wanted.setSex(interpolRedNotice.getSexId());

        if (interpolRedNotice.getHairsId() != null) {
            String hairColor = interpolRedNotice.getHairsId().get(0);
            switch (hairColor) {
                case "BLA":
                    hairColor = "black";
                    break;
                case "GRY":
                    hairColor = "gray";
                    break;
                case "BRO":
                    hairColor = "brown";
                    break;
                case "YELB":
                    hairColor = "blond";
                    break;
                case "RED":
                    hairColor = "red";
                    break;
                default:
                    hairColor = null;
            }
            this.wanted.setHairColor(hairColor);
        }

        if (interpolRedNotice.getEyesColorsId() != null) {
            String eyeColor = interpolRedNotice.getEyesColorsId().get(0);
            switch (eyeColor) {
                case "BLA":
                    eyeColor = "black";
                    break;
                case "BROH":
                    eyeColor = "hazel";
                    break;
                case "BROD":
                    eyeColor = "brown";
                    break;
                case "BRO":
                    eyeColor = "brown";
                    break;
                case "BLU":
                    eyeColor = "blue";
                    break;
                case "GRE":
                    eyeColor = "green";
                default:
                    eyeColor = null;
            }
            this.wanted.setEyeColor(eyeColor);
        }

        this.wanted.setDateOfBirth(interpolRedNotice.getDateOfBirth());

        this.wanted.setPlaceOfBirth(interpolRedNotice.getPlaceOfBirth());

        if (interpolRedNotice.getCountryOfBirthId() != null) {
            Nationality nationality = nationalityDAO.findByAlpha2(interpolRedNotice.getCountryOfBirthId());
            String country = nationality.getCountry();
            String placeOfBirth;
            if (this.wanted.getPlaceOfBirth() != null) {
                placeOfBirth = this.wanted.getPlaceOfBirth() + ", " + country;
            } else {
                placeOfBirth = country;
            }
            this.wanted.setPlaceOfBirth(placeOfBirth);
        }

        this.wanted.setInterpolId(interpolRedNotice.getEntityId());

        if (interpolRedNotice.getNationalities() != null) {
            for (String code : interpolRedNotice.getNationalities()) {

                Nationality nationality = nationalityDAO.findByAlpha2(code);
                nationalities.add(nationality);
            }
            this.wanted.setNationalities(nationalities);
        }

        if (interpolRedNotice.getLanguagesSpokenIds() != null) {
            for (String code : interpolRedNotice.getLanguagesSpokenIds()) {

                LanguageSpoken languageSpoken = languageSpokenDAO.findByAlpha3(code);
                languagesSpoken.add(languageSpoken);
            }
            this.wanted.setLanguagesSpoken(languagesSpoken);
        }

        if ((interpolRedNotice.getArrestWarrants() != null) && (!interpolRedNotice.getArrestWarrants().isEmpty())) {
            charges = new ArrayList<>();
            Charge charge;
            for (InterpolRedNoticeArrestWarrant arrestWarrant : interpolRedNotice.getArrestWarrants()) {
                if (arrestWarrant.getChargeTranslation() != null) {
                    charge = new Charge(arrestWarrant.getChargeTranslation(), arrestWarrant.getIssuingCountryId(), this.wanted);
                } else {
                    charge = new Charge(arrestWarrant.getCharge(), arrestWarrant.getIssuingCountryId(), this.wanted);
                }
                charges.add(charge);
            }
            this.wanted.setCharges(charges);
        }



        return this.wanted;
    }
}