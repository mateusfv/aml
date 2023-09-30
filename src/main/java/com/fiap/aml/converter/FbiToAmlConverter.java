package com.fiap.aml.converter;

import com.fiap.aml.dao.LanguageSpokenDAO;
import com.fiap.aml.dao.NationalityDAO;
import com.fiap.aml.entity.*;
import com.fiap.aml.temp.FbiWanted;

import java.time.Year;
import java.util.*;

public class FbiToAmlConverter {

    // Fields
    private FbiWanted fbiWanted;
    private Wanted wanted;
    private NationalityDAO nationalityDAO;
    private LanguageSpokenDAO languageSpokenDAO;
    private List<AlternativeName> aliases;
    private List<DateOfBirthDeclared> datesOfBirthDeclared;
    private List<Charge> charges;
    private Set<Nationality> nationalities;
    private Set<LanguageSpoken> languagesSpoken;
    private List<Occupation> occupations;
    private List<PossibleLocation> possibleLocations;
    private List<Detail> details;

    // Constructor
    public FbiToAmlConverter(FbiWanted fbiWanted, NationalityDAO nationalityDAO, LanguageSpokenDAO languageSpokenDAO) {
        this.fbiWanted = fbiWanted;
        this.nationalityDAO = nationalityDAO;
        this.languageSpokenDAO = languageSpokenDAO;
    }

    // Converter
    public Wanted getWanted() {
        this.wanted = new Wanted();
        this.aliases = new ArrayList<>();
        this.datesOfBirthDeclared = new ArrayList<>();
        this.nationalities = new HashSet<>();
        this.languagesSpoken = new HashSet<>();

        if (fbiWanted.getTitle() != null) {
            this.wanted.setNameTitle(fbiWanted.getTitle().toUpperCase().trim());
        }

        if (fbiWanted.getSex() != null && !fbiWanted.getSex().isEmpty()) {
            this.wanted.setSex(fbiWanted.getSex().trim().substring(0, 1).toUpperCase());
        }

        if (fbiWanted.getLegatNames() != null) {
            aliases = new ArrayList<>();

            if (this.wanted.getAlternativeNames() != null) {
                aliases = new ArrayList<>(this.wanted.getAlternativeNames());
            }

            for (String legatName : fbiWanted.getLegatNames()) {
                if ((!legatName.isBlank()) && (!legatName.isEmpty())) {
                    AlternativeName alias = new AlternativeName(legatName, this.wanted);
                    aliases.add(alias);
                }
            }

            if (!aliases.isEmpty()) {
                this.wanted.setAlternativeNames(aliases);
            }
        }

        if (fbiWanted.getAliases() != null) {
            aliases = new ArrayList<>();

            if (this.wanted.getAlternativeNames() != null) {
                aliases = new ArrayList<>(this.wanted.getAlternativeNames());
            }

            for (String fbiAlias : fbiWanted.getAliases()) {
                if ((!fbiAlias.isEmpty()) && (!fbiAlias.isBlank())) {
                    AlternativeName alias = new AlternativeName(fbiAlias, this.wanted);
                    aliases.add(alias);
                }
            }

            if (!aliases.isEmpty()) {
                this.wanted.setAlternativeNames(aliases);
            }
        }

        if (fbiWanted.getHair() != null) {
            this.wanted.setHairColor(fbiWanted.getHair().trim().toLowerCase());
        }

        if (fbiWanted.getEyes() != null) {
            this.wanted.setEyeColor(fbiWanted.getEyes().trim().toLowerCase());
        }

        if (fbiWanted.getRace() != null) {
            this.wanted.setRace(fbiWanted.getRace().trim().toLowerCase());
        }


        Year currentYear = Year.now();
        Integer ageMin = fbiWanted.getAgeMin();
        Integer ageMax = fbiWanted.getAgeMax();

        if ((ageMin != null && ageMax != null) && (ageMin > 0 && ageMax > 0)) {
            this.wanted.setDateOfBirth("Circa " + (currentYear.getValue() - ((ageMin + ageMax)/2)));
        } else {
            this.wanted.setDateOfBirth(null);
        }

        if (fbiWanted.getDatesOfBirthUsed() != null) {
            datesOfBirthDeclared = new ArrayList<>();

            if (this.wanted.getDatesOfBirthDeclared() != null) {
                datesOfBirthDeclared = new ArrayList<>(this.wanted.getDatesOfBirthDeclared());
            }

            for (String date : fbiWanted.getDatesOfBirthUsed()) {
                if ((!date.isEmpty()) && (!date.isBlank())) {
                    DateOfBirthDeclared dateOfBirthDeclared = new DateOfBirthDeclared(date, this.wanted);
                    datesOfBirthDeclared.add(dateOfBirthDeclared);
                }
            }

            if (!datesOfBirthDeclared.isEmpty()) {
                this.wanted.setDatesOfBirthDeclared(datesOfBirthDeclared);
            }
        }

        this.wanted.setPlaceOfBirth(fbiWanted.getPlaceOfBirth());

        //todo ???
        if ((fbiWanted.getDescription() != null) && (!fbiWanted.getDescription().isBlank())) {
            charges = new ArrayList<>();

            if (this.wanted.getCharges() != null) {
                charges = new ArrayList<>(this.wanted.getCharges());
            }

            Charge charge = new Charge(fbiWanted.getDescription(), "US", this.wanted);
            charges.add(charge);
            this.wanted.setCharges(charges);
        }

        if (fbiWanted.getNationality() != null) {
            nationalities = new HashSet<>();

            if (this.wanted.getNationalities() != null) {
                nationalities = new HashSet<>(this.wanted.getNationalities());
            }

            Nationality nationality = nationalityDAO.findByGentilic(fbiWanted.getNationality());

            nationalities.add(nationality);

            this.wanted.setNationalities(nationalities);
        }

        if (fbiWanted.getLanguages() != null) {
            languagesSpoken = new HashSet<>();
            List<String> languageStrings = new ArrayList<>();

            if (this.wanted.getLanguagesSpoken() != null) {
                languagesSpoken = new HashSet<>(this.wanted.getLanguagesSpoken());
            }

            for (String string : fbiWanted.getLanguages()) {

                if (string.contains("and")) {
                    List<String> tempLanguageList = List.of(string.split(" and "));
                    languageStrings.addAll(tempLanguageList);
                }

                if (string.contains(",")) {
                    List<String> tempLanguageList = List.of(string.split(","));
                    for (String item : tempLanguageList) {
                       languageStrings.add(item.trim());
                    }
                }

                if (string.contains(";")) {
                    List<String> tempLanguageList = List.of(string.split(";"));
                    for (String item : tempLanguageList) {
                        languageStrings.add(item.trim());
                    }
                }

                if ((!string.contains("and")) && !(string.contains(",") || string.contains(";"))) {
                    languageStrings.add(string);
                }
            }

            for (String language : languageStrings) {
                LanguageSpoken languageSpoken = languageSpokenDAO.findByName(language);

                if (languageSpoken != null) {
                    languagesSpoken.add(languageSpoken);
                }
            }

            this.wanted.setLanguagesSpoken(languagesSpoken);
        }

        if ((fbiWanted.getOccupations() != null) && (!fbiWanted.getOccupations().isEmpty())) {
            occupations = new ArrayList<>();

            if (this.wanted.getOccupations() != null) {
                occupations = new ArrayList<>(this.wanted.getOccupations());
            }

            for (String occupation : fbiWanted.getOccupations()) {
                if ((!occupation.isBlank()) && (occupation != null)) {
                    Occupation tempOccupation = new Occupation(occupation, this.wanted);
                    occupations.add(tempOccupation);
                }
            }

            if (!occupations.isEmpty()) {
                this.wanted.setOccupations(occupations);
            }
        }

        if (fbiWanted.getPossibleCountries() != null) {
            possibleLocations = new ArrayList<>();

            if (this.wanted.getPossibleLocations() != null) {
                possibleLocations = new ArrayList<>(this.wanted.getPossibleLocations());
            }

            for (String location : fbiWanted.getPossibleCountries()) {
                PossibleLocation tempLocation = new PossibleLocation(location, this.wanted);
                possibleLocations.add(tempLocation);
            }

            this.wanted.setPossibleLocations(possibleLocations);
        }

        if (fbiWanted.getPossibleStates() != null) {
            possibleLocations = new ArrayList<>();

            if (this.wanted.getPossibleLocations() != null) {
                possibleLocations = new ArrayList<>(this.wanted.getPossibleLocations());
            }

            for (String location : fbiWanted.getPossibleStates()) {
                PossibleLocation tempLocation = new PossibleLocation(location, this.wanted);
                possibleLocations.add(tempLocation);
            }

            this.wanted.setPossibleLocations(possibleLocations);
        }

        if (fbiWanted.getLocations() != null) {
            possibleLocations = new ArrayList<>();

            if (this.wanted.getPossibleLocations() != null) {
                possibleLocations = new ArrayList<>(this.wanted.getPossibleLocations());
            }

            for (String location : fbiWanted.getLocations()) {
                PossibleLocation tempLocation = new PossibleLocation(location, this.wanted);
                possibleLocations.add(tempLocation);
            }

            this.wanted.setPossibleLocations(possibleLocations);
        }

        if (fbiWanted.getFieldOffices() != null) {
            possibleLocations = new ArrayList<>();

            if (this.wanted.getPossibleLocations() != null) {
                possibleLocations = new ArrayList<>(this.wanted.getPossibleLocations());
            }

            for (String location : fbiWanted.getFieldOffices()) {
                PossibleLocation tempLocation = new PossibleLocation(location, this.wanted);
                possibleLocations.add(tempLocation);
            }

            this.wanted.setPossibleLocations(possibleLocations);
        }

        this.wanted.setFbiId(fbiWanted.getUid());

        this.wanted.setFbiUrl(fbiWanted.getUrl());

        this.wanted.setNcic(fbiWanted.getNcic());

        if ((fbiWanted.getDetails() != null) && (!fbiWanted.getDetails().isBlank())) {
            details = new ArrayList<>();

            if (this.wanted.getDetails() != null) {
                details = new ArrayList<>(this.wanted.getDetails());
            }

            Detail detail = new Detail(fbiWanted.getDetails(), this.wanted);

            details.add(detail);

            this.wanted.setDetails(details);
        }

        if ((fbiWanted.getCaution() != null) && (!fbiWanted.getCaution().isBlank())) {
            details = new ArrayList<>();

            if (this.wanted.getDetails() != null) {
                details = new ArrayList<>(this.wanted.getDetails());
            }

            Detail detail = new Detail(fbiWanted.getCaution(), this.wanted);

            details.add(detail);

            this.wanted.setDetails(details);
        }

        if ((fbiWanted.getWarningMessage() != null) && (!fbiWanted.getWarningMessage().isBlank())) {
            details = new ArrayList<>();

            if (this.wanted.getDetails() != null) {
                details = new ArrayList<>(this.wanted.getDetails());
            }

            Detail detail = new Detail(fbiWanted.getWarningMessage(), this.wanted);

            details.add(detail);

            this.wanted.setDetails(details);
        }

        if ((fbiWanted.getRemarks() != null) && (!fbiWanted.getRemarks().isBlank())) {
            details = new ArrayList<>();

            if (this.wanted.getDetails() != null) {
                details = new ArrayList<>(this.wanted.getDetails());
            }

            Detail detail = new Detail(fbiWanted.getRemarks(), this.wanted);

            details.add(detail);

            this.wanted.setDetails(details);
        }

        if ((fbiWanted.getAdditionalInformation() != null) && (!fbiWanted.getAdditionalInformation().isBlank())) {
            details = new ArrayList<>();

            if (this.wanted.getDetails() != null) {
                details = new ArrayList<>(this.wanted.getDetails());
            }

            Detail detail = new Detail(fbiWanted.getAdditionalInformation(), this.wanted);

            details.add(detail);

            this.wanted.setDetails(details);
        }

        if (!fbiWanted.getImages().isEmpty()) {
            this.wanted.setImagePath(fbiWanted.getImages().get(0).getOriginal());
        }

        return this.wanted;
    }
}