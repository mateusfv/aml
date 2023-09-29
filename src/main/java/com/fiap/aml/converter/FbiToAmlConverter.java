package com.fiap.aml.converter;

import com.fiap.aml.dao.LanguageSpokenDAO;
import com.fiap.aml.dao.NationalityDAO;
import com.fiap.aml.entity.*;
import com.fiap.aml.temp.FbiWanted;

import java.time.Year;
import java.util.*;

public class FbiToAmlConverter {
    private FbiWanted fbiWanted;
    private Wanted wanted;
    private List<AlternativeName> tempAliases;
    private List<DateOfBirthDeclared> tempDatesOfBirthDeclared;
    private List<Charge> tempCharges;
    private Set<Nationality> tempNationalities;
    private NationalityDAO nationalityDAO;
    private Set<LanguageSpoken> tempLanguagesSpoken;
    private LanguageSpokenDAO languageSpokenDAO;
    private List<Occupation> tempOccupations;
    private List<PossibleLocation> tempPossibleLocations;
    private List<Detail> tempDetails;

    public FbiToAmlConverter(FbiWanted fbiWanted, NationalityDAO nationalityDAO, LanguageSpokenDAO languageSpokenDAO) {
        this.fbiWanted = fbiWanted;
        this.nationalityDAO = nationalityDAO;
        this.languageSpokenDAO = languageSpokenDAO;
    }

    public Wanted getWanted() {
        this.wanted = new Wanted();
        this.tempAliases = new ArrayList<>();
        this.tempDatesOfBirthDeclared = new ArrayList<>();
        this.tempNationalities = new HashSet<>();
        this.tempLanguagesSpoken = new HashSet<>();

        if (fbiWanted.getTitle() != null) {
            this.wanted.setFullName(fbiWanted.getTitle().toUpperCase().trim());
        }

        if (fbiWanted.getSex() != null && !fbiWanted.getSex().isEmpty()) {
            this.wanted.setSex(fbiWanted.getSex().trim().substring(0, 1).toUpperCase());
        }

//        DEPRECATED
//        if (fbiWanted.getLegatNames() != null) {
//            tempList = new ArrayList<>();
//
//            if (this.wanted.getAlternativeNames() != null) {
//                tempList = new ArrayList<>(this.wanted.getAlternativeNames());
//            }
//
//            for (String legatName : fbiWanted.getLegatNames()) {
//                tempList.add(legatName.trim().toUpperCase());
//            }
//
//            this.wanted.setAlternativeNames(tempList);
//        }

        if (fbiWanted.getLegatNames() != null) {
            tempAliases = new ArrayList<>();

            if (this.wanted.getAlternativeNames() != null) {
                tempAliases = new ArrayList<>(this.wanted.getAlternativeNames());
            }

            for (String legatName : fbiWanted.getLegatNames()) {
                AlternativeName alias = new AlternativeName(legatName, this.wanted);
                tempAliases.add(alias);
            }
            this.wanted.setAlternativeNames(tempAliases);
        }

        if (fbiWanted.getAliases() != null) {
            tempAliases = new ArrayList<>();

            if (this.wanted.getAlternativeNames() != null) {
                tempAliases = new ArrayList<>(this.wanted.getAlternativeNames());
            }

            for (String fbiAlias : fbiWanted.getAliases()) {
                AlternativeName alias = new AlternativeName(fbiAlias, this.wanted);
                tempAliases.add(alias);
            }
            this.wanted.setAlternativeNames(tempAliases);
        }

//        if (fbiWanted.getHair() != null) {
//            this.wanted.setHairColor(fbiWanted.getHair().trim().toLowerCase());
//        }
//
//        if (fbiWanted.getEyes() != null) {
//            this.wanted.setEyeColor(fbiWanted.getEyes().trim().toLowerCase());
//        }
//
//        if (fbiWanted.getRace() != null) {
//            this.wanted.setRace(fbiWanted.getRace().trim().toLowerCase());
//        }


        Year currentYear = Year.now();
        Integer ageMin = fbiWanted.getAgeMin();
        Integer ageMax = fbiWanted.getAgeMax();

        if ((ageMin != null && ageMax != null) && (ageMin > 0 && ageMax > 0)) {
            this.wanted.setDateOfBirth("Circa " + (currentYear.getValue() - ((ageMin + ageMax)/2)));
            this.wanted.setAgeRange(ageMin + " to " + ageMax);
        } else {
            this.wanted.setDateOfBirth(null);
            this.wanted.setAgeRange(fbiWanted.getAgeRange());
        }

        if (fbiWanted.getDatesOfBirthUsed() != null) {
            tempDatesOfBirthDeclared = new ArrayList<>();

            if (this.wanted.getDatesOfBirthDeclared() != null) {
                tempDatesOfBirthDeclared = new ArrayList<>(this.wanted.getDatesOfBirthDeclared());
            }

            for (String date : fbiWanted.getDatesOfBirthUsed()) {
                DateOfBirthDeclared dateOfBirthDeclared = new DateOfBirthDeclared(date, this.wanted);
                tempDatesOfBirthDeclared.add(dateOfBirthDeclared);
            }

            this.wanted.setDatesOfBirthDeclared(tempDatesOfBirthDeclared);
        }

        this.wanted.setPlaceOfBirth(fbiWanted.getPlaceOfBirth());


        if (fbiWanted.getPlaceOfBirth() != null) {
            this.wanted.setCountryOfBirth(fbiWanted.getPlaceOfBirth());
        }

        //todo ???
        if (fbiWanted.getDescription() != null) {
            tempCharges = new ArrayList<>();

            if (this.wanted.getCharges() != null) {
                tempCharges = new ArrayList<>(this.wanted.getCharges());
            }

            Charge charge = new Charge(fbiWanted.getDescription(), "US", this.wanted);
            tempCharges.add(charge);
            this.wanted.setCharges(tempCharges);
        }

        if (fbiWanted.getNationality() != null) {
            tempNationalities = new HashSet<>();

            if (this.wanted.getNationalities() != null) {
                tempNationalities = new HashSet<>(this.wanted.getNationalities());
            }

            Nationality nationality = nationalityDAO.findByGentilic(fbiWanted.getNationality());

            tempNationalities.add(nationality);

            this.wanted.setNationalities(tempNationalities);
        }

        if (fbiWanted.getLanguages() != null) {
            tempLanguagesSpoken = new HashSet<>();
            List<String> languageStrings = new ArrayList<>();

            if (this.wanted.getLanguagesSpoken() != null) {
                tempLanguagesSpoken = new HashSet<>(this.wanted.getLanguagesSpoken());
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
                    tempLanguagesSpoken.add(languageSpoken);
                }
            }

            this.wanted.setLanguagesSpoken(tempLanguagesSpoken);
        }

        if (fbiWanted.getOccupations() != null) {
            tempOccupations = new ArrayList<>();

            if (this.wanted.getOccupations() != null) {
                tempOccupations = new ArrayList<>(this.wanted.getOccupations());
            }

            for (String occupation : fbiWanted.getOccupations()) {
                Occupation tempOccupation = new Occupation(occupation, this.wanted);
                tempOccupations.add(tempOccupation);
            }

            this.wanted.setOccupations(tempOccupations);
        }

        if (fbiWanted.getPossibleCountries() != null) {
            tempPossibleLocations = new ArrayList<>();

            if (this.wanted.getPossibleLocations() != null) {
                tempPossibleLocations = new ArrayList<>(this.wanted.getPossibleLocations());
            }

            for (String location : fbiWanted.getPossibleCountries()) {
                PossibleLocation tempLocation = new PossibleLocation(location, this.wanted);
                tempPossibleLocations.add(tempLocation);
            }

            this.wanted.setPossibleLocations(tempPossibleLocations);
        }

        if (fbiWanted.getPossibleStates() != null) {
            tempPossibleLocations = new ArrayList<>();

            if (this.wanted.getPossibleLocations() != null) {
                tempPossibleLocations = new ArrayList<>(this.wanted.getPossibleLocations());
            }

            for (String location : fbiWanted.getPossibleStates()) {
                PossibleLocation tempLocation = new PossibleLocation(location, this.wanted);
                tempPossibleLocations.add(tempLocation);
            }

            this.wanted.setPossibleLocations(tempPossibleLocations);
        }

        if (fbiWanted.getLocations() != null) {
            tempPossibleLocations = new ArrayList<>();

            if (this.wanted.getPossibleLocations() != null) {
                tempPossibleLocations = new ArrayList<>(this.wanted.getPossibleLocations());
            }

            for (String location : fbiWanted.getLocations()) {
                PossibleLocation tempLocation = new PossibleLocation(location, this.wanted);
                tempPossibleLocations.add(tempLocation);
            }

            this.wanted.setPossibleLocations(tempPossibleLocations);
        }

        if (fbiWanted.getFieldOffices() != null) {
            tempPossibleLocations = new ArrayList<>();

            if (this.wanted.getPossibleLocations() != null) {
                tempPossibleLocations = new ArrayList<>(this.wanted.getPossibleLocations());
            }

            for (String location : fbiWanted.getFieldOffices()) {
                PossibleLocation tempLocation = new PossibleLocation(location, this.wanted);
                tempPossibleLocations.add(tempLocation);
            }

            this.wanted.setPossibleLocations(tempPossibleLocations);
        }

        this.wanted.setFbiId(fbiWanted.getUid());

        this.wanted.setFbiUrl(fbiWanted.getUrl());

        this.wanted.setNcic(fbiWanted.getNcic());

        if (fbiWanted.getDetails() != null) {
            tempDetails = new ArrayList<>();

            if (this.wanted.getDetails() != null) {
                tempDetails = new ArrayList<>(this.wanted.getDetails());
            }

            Detail detail = new Detail(fbiWanted.getDetails(), this.wanted);

            tempDetails.add(detail);

            this.wanted.setDetails(tempDetails);
        }

        if (fbiWanted.getCaution() != null) {
            tempDetails = new ArrayList<>();

            if (this.wanted.getDetails() != null) {
                tempDetails = new ArrayList<>(this.wanted.getDetails());
            }

            Detail detail = new Detail(fbiWanted.getCaution(), this.wanted);

            tempDetails.add(detail);

            this.wanted.setDetails(tempDetails);
        }

        if (fbiWanted.getWarningMessage() != null) {
            tempDetails = new ArrayList<>();

            if (this.wanted.getDetails() != null) {
                tempDetails = new ArrayList<>(this.wanted.getDetails());
            }

            Detail detail = new Detail(fbiWanted.getWarningMessage(), this.wanted);

            tempDetails.add(detail);

            this.wanted.setDetails(tempDetails);
        }

        if (fbiWanted.getRemarks() != null) {
            tempDetails = new ArrayList<>();

            if (this.wanted.getDetails() != null) {
                tempDetails = new ArrayList<>(this.wanted.getDetails());
            }

            Detail detail = new Detail(fbiWanted.getRemarks(), this.wanted);

            tempDetails.add(detail);

            this.wanted.setDetails(tempDetails);
        }

        if (fbiWanted.getAdditionalInformation() != null) {
            tempDetails = new ArrayList<>();

            if (this.wanted.getDetails() != null) {
                tempDetails = new ArrayList<>(this.wanted.getDetails());
            }

            Detail detail = new Detail(fbiWanted.getAdditionalInformation(), this.wanted);

            tempDetails.add(detail);

            this.wanted.setDetails(tempDetails);
        }

        if (!fbiWanted.getImages().isEmpty()) {
            this.wanted.setImagePath(fbiWanted.getImages().get(0).getOriginal());
        }

        return this.wanted;
    }
}