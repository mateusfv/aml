package com.fiap.aml.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fiap.aml.entity.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WantedDTO {

    // Fields
    @JsonIgnore
    private int id;

    private String nameTitle;

    private String sex;

    private String race;

    private String hairColor;

    private String eyeColor;

    private String dateOfBirth;

    private String placeOfBirth;

    private String fbiId;

    private String fbiUrl;

    private String interpolId;

    private String interpolUrl;

    private String ncic;

    private String imagePath;

    private List<ChargeDTO> charges;

    private List<AlternativeNameDTO> alternativeNames;

    private List<OccupationDTO> occupations;

    private List<DetailDTO> details;

    private List<PossibleLocationDTO> possibleLocations;

    private List<IdentityNumberUsedDTO> identityNumbersUsed;

    private List<NationalityDTO> nationalities;

    private List<LanguageSpokenDTO> languagesSpoken;

    private HashMap<Integer, String> amlRiskIndex;

    // Constructors
    public WantedDTO() {

    }

    public WantedDTO(Wanted wanted) {
        this.id = wanted.getId();
        this.nameTitle = wanted.getNameTitle();
        this.sex = wanted.getSex();
        this.race = wanted.getRace();
        this.hairColor = wanted.getHairColor();
        this.eyeColor = wanted.getEyeColor();
        this.dateOfBirth = wanted.getDateOfBirth();
        this.placeOfBirth = wanted.getPlaceOfBirth();
        this.fbiId = wanted.getFbiId();
        this.fbiUrl = wanted.getFbiUrl();
        this.interpolId = wanted.getInterpolId();
        this.interpolUrl = wanted.getInterpolUrl();
        this.ncic = wanted.getNcic();
        this.imagePath = wanted.getImagePath();
        this.amlRiskIndex = wanted.getAmlRiskIndex();

        List<ChargeDTO> chargeDTOs = new ArrayList<>(wanted.getCharges().size());
        this.charges = new ArrayList<>();
        for (Charge charge : wanted.getCharges()) {
            if (charge != null) {
                chargeDTOs.add(new ChargeDTO(charge));
            }
        }

        if (!chargeDTOs.isEmpty()) {
            this.charges.addAll(chargeDTOs);
        }

        List<AlternativeNameDTO> alternativeNameDTOs = new ArrayList<>();
        this.alternativeNames = new ArrayList<>();
        for (AlternativeName alternativeName : wanted.getAlternativeNames()) {
            alternativeNameDTOs.add(new AlternativeNameDTO(alternativeName));
        }
        this.alternativeNames.addAll(alternativeNameDTOs);

        List<OccupationDTO> occupationDTOs = new ArrayList<>();
        this.occupations = new ArrayList<>();
        for (Occupation occupation : wanted.getOccupations()) {
            occupationDTOs.add(new OccupationDTO(occupation));
        }
        this.occupations.addAll(occupationDTOs);

        List<DetailDTO> detailDTOs = new ArrayList<>();
        this.details = new ArrayList<>();
        for (Detail detail : wanted.getDetails()) {
            detailDTOs.add(new DetailDTO(detail));
        }
        this.details.addAll(detailDTOs);

        List<PossibleLocationDTO> possibleLocationDTOs = new ArrayList<>();
        this.possibleLocations = new ArrayList<>();
        for (PossibleLocation possibleLocation : wanted.getPossibleLocations()) {
            possibleLocationDTOs.add(new PossibleLocationDTO(possibleLocation));
        }
        this.possibleLocations.addAll(possibleLocationDTOs);

        this.identityNumbersUsed = new ArrayList<>();
        if (!this.identityNumbersUsed.isEmpty()) {
            List<IdentityNumberUsedDTO> identityNumberUsedDTOs = new ArrayList<>();

            for (IdentityNumberUsed identityNumberUsed : wanted.getIdentityNumbersUsed()) {
                identityNumberUsedDTOs.add(new IdentityNumberUsedDTO(identityNumberUsed));
            }
            this.identityNumbersUsed.addAll(identityNumberUsedDTOs);
        } else {
            this.identityNumbersUsed = null;
        }

        List<NationalityDTO> nationalityDTOs = new ArrayList<>();
        this.nationalities = new ArrayList<>();
        for (Nationality nationality : wanted.getNationalities()) {
            nationalityDTOs.add(new NationalityDTO(nationality));
        }
        this.nationalities.addAll(nationalityDTOs);

        List<LanguageSpokenDTO> languageSpokenDTOs = new ArrayList<>();
        this.languagesSpoken = new ArrayList<>();
        for (LanguageSpoken languageSpoken : wanted.getLanguagesSpoken()) {
            languageSpokenDTOs.add(new LanguageSpokenDTO(languageSpoken));
        }
        this.languagesSpoken.addAll(languageSpokenDTOs);
    }

    public WantedDTO(int id, String nameTitle, String sex, String race, String hairColor, String eyeColor, String dateOfBirth, String placeOfBirth, String fbiId, String fbiUrl, String interpolId, String interpolUrl, String ncic, String imagePath, List<ChargeDTO> charges, List<AlternativeNameDTO> alternativeNames, List<OccupationDTO> occupations, List<DetailDTO> details, List<PossibleLocationDTO> possibleLocations, List<IdentityNumberUsedDTO> identityNumbersUsed, List<NationalityDTO> nationalities, List<LanguageSpokenDTO> languagesSpoken, HashMap<Integer, String> amlRiskIndex) {
        this.id = id;
        this.nameTitle = nameTitle;
        this.sex = sex;
        this.race = race;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.fbiId = fbiId;
        this.fbiUrl = fbiUrl;
        this.interpolId = interpolId;
        this.interpolUrl = interpolUrl;
        this.ncic = ncic;
        this.imagePath = imagePath;
        this.charges = charges;
        this.alternativeNames = alternativeNames;
        this.occupations = occupations;
        this.details = details;
        this.possibleLocations = possibleLocations;
        this.identityNumbersUsed = identityNumbersUsed;
        this.nationalities = nationalities;
        this.languagesSpoken = languagesSpoken;
        this.amlRiskIndex = amlRiskIndex;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameTitle() {
        return nameTitle;
    }

    public void setNameTitle(String nameTitle) {
        this.nameTitle = nameTitle;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getFbiId() {
        return fbiId;
    }

    public void setFbiId(String fbiId) {
        this.fbiId = fbiId;
    }

    public String getFbiUrl() {
        return fbiUrl;
    }

    public void setFbiUrl(String fbiUrl) {
        this.fbiUrl = fbiUrl;
    }

    public String getInterpolId() {
        return interpolId;
    }

    public void setInterpolId(String interpolId) {
        this.interpolId = interpolId;
    }

    public String getInterpolUrl() {
        return interpolUrl;
    }

    public void setInterpolUrl(String interpolUrl) {
        this.interpolUrl = interpolUrl;
    }

    public String getNcic() {
        return ncic;
    }

    public void setNcic(String ncic) {
        this.ncic = ncic;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<ChargeDTO> getCharges() {
        return charges;
    }

    public void setCharges(List<ChargeDTO> charges) {
        this.charges = charges;
    }

    public List<AlternativeNameDTO> getAlternativeNames() {
        return alternativeNames;
    }

    public void setAlternativeNames(List<AlternativeNameDTO> alternativeNames) {
        this.alternativeNames = alternativeNames;
    }

    public List<OccupationDTO> getOccupations() {
        return occupations;
    }

    public void setOccupations(List<OccupationDTO> occupations) {
        this.occupations = occupations;
    }

    public List<DetailDTO> getDetails() {
        return details;
    }

    public void setDetails(List<DetailDTO> details) {
        this.details = details;
    }

    public List<PossibleLocationDTO> getPossibleLocations() {
        return possibleLocations;
    }

    public void setPossibleLocations(List<PossibleLocationDTO> possibleLocations) {
        this.possibleLocations = possibleLocations;
    }

    public List<IdentityNumberUsedDTO> getIdentityNumbersUsed() {
        return identityNumbersUsed;
    }

    public void setIdentityNumbersUsed(List<IdentityNumberUsedDTO> identityNumbersUsed) {
        this.identityNumbersUsed = identityNumbersUsed;
    }

    public List<NationalityDTO> getNationalities() {
        return nationalities;
    }

    public void setNationalities(List<NationalityDTO> nationalities) {
        this.nationalities = nationalities;
    }

    public List<LanguageSpokenDTO> getLanguagesSpoken() {
        return languagesSpoken;
    }

    public void setLanguagesSpoken(List<LanguageSpokenDTO> languagesSpoken) {
        this.languagesSpoken = languagesSpoken;
    }

    public HashMap<Integer, String> getAmlRiskIndex() {
        return amlRiskIndex;
    }

    public void setAmlRiskIndex(HashMap<Integer, String> amlRiskIndex) {
        this.amlRiskIndex = amlRiskIndex;
    }

    // toString()

    @Override
    public String toString() {
        return "WantedDTO{" +
                "id=" + id +
                ", nameTitle='" + nameTitle + '\'' +
                ", sex='" + sex + '\'' +
                ", race='" + race + '\'' +
                ", hairColor='" + hairColor + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", fbiId='" + fbiId + '\'' +
                ", fbiUrl='" + fbiUrl + '\'' +
                ", interpolId='" + interpolId + '\'' +
                ", interpolUrl='" + interpolUrl + '\'' +
                ", ncic='" + ncic + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", charges=" + charges +
                ", alternativeNames=" + alternativeNames +
                ", occupations=" + occupations +
                ", details=" + details +
                ", possibleLocations=" + possibleLocations +
                ", identityNumbersUsed=" + identityNumbersUsed +
                ", nationalities=" + nationalities +
                ", languagesSpoken=" + languagesSpoken +
                ", amlRiskIndex=" + amlRiskIndex +
                '}';
    }
}