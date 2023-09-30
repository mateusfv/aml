package com.fiap.aml.temp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InterpolRedNotice {

    // Fields
    @JsonProperty("date_of_birth")
    private String dateOfBirth;

    @JsonProperty("distinguishing_marks")
    private String distinguishingMarks;

    private double weight;

    private List<String> nationalities;

    @JsonProperty("entity_id")
    private String entityId;

    @JsonProperty("eyes_colors_id")
    private List<String> eyesColorsId;

    @JsonProperty("sex_id")
    private String sexId;

    @JsonProperty("place_of_birth")
    private String placeOfBirth;

    private String forename;

    @JsonProperty("arrest_warrants")
    private List<InterpolRedNoticeArrestWarrant> arrestWarrants;

    @JsonProperty("country_of_birth_id")
    private String countryOfBirthId;

    @JsonProperty("hairs_id")
    private List<String> hairsId;

    private String name;

    @JsonProperty("languages_spoken_ids")
    private List<String> languagesSpokenIds;

    private double height;

    private String imagePath;

    // Constructors
    public InterpolRedNotice() {

    }

    public InterpolRedNotice(String dateOfBirth, String distinguishingMarks, double weight, List<String> nationalities, String entityId, List<String> eyesColorsId, String sexId, String placeOfBirth, String forename, List<InterpolRedNoticeArrestWarrant> arrestWarrants, String countryOfBirthId, List<String> hairsId, String name, List<String> languagesSpokenIds, double height, String imagePath) {
        this.dateOfBirth = dateOfBirth;
        this.distinguishingMarks = distinguishingMarks;
        this.weight = weight;
        this.nationalities = nationalities;
        this.entityId = entityId;
        this.eyesColorsId = eyesColorsId;
        this.sexId = sexId;
        this.placeOfBirth = placeOfBirth;
        this.forename = forename;
        this.arrestWarrants = arrestWarrants;
        this.countryOfBirthId = countryOfBirthId;
        this.hairsId = hairsId;
        this.name = name;
        this.languagesSpokenIds = languagesSpokenIds;
        this.height = height;
        this.imagePath = imagePath;
    }

    // Getters and Setters
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDistinguishingMarks() {
        return distinguishingMarks;
    }

    public void setDistinguishingMarks(String distinguishingMarks) {
        this.distinguishingMarks = distinguishingMarks;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public List<String> getNationalities() {
        return nationalities;
    }

    public void setNationalities(List<String> nationalities) {
        this.nationalities = nationalities;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public List<String> getEyesColorsId() {
        return eyesColorsId;
    }

    public void setEyesColorsId(List<String> eyesColorsId) {
        this.eyesColorsId = eyesColorsId;
    }

    public String getSexId() {
        return sexId;
    }

    public void setSexId(String sexId) {
        this.sexId = sexId;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public List<InterpolRedNoticeArrestWarrant> getArrestWarrants() {
        return arrestWarrants;
    }

    public void setArrestWarrants(List<InterpolRedNoticeArrestWarrant> arrestWarrants) {
        this.arrestWarrants = arrestWarrants;
    }

    public String getCountryOfBirthId() {
        return countryOfBirthId;
    }

    public void setCountryOfBirthId(String countryOfBirthId) {
        this.countryOfBirthId = countryOfBirthId;
    }

    public List<String> getHairsId() {
        return hairsId;
    }

    public void setHairsId(List<String> hairsId) {
        this.hairsId = hairsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLanguagesSpokenIds() {
        return languagesSpokenIds;
    }

    public void setLanguagesSpokenIds(List<String> languagesSpokenIds) {
        this.languagesSpokenIds = languagesSpokenIds;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    // toString()
    @Override
    public String toString() {
        return "InterpolRedNotice{" +
                "dateOfBirth='" + dateOfBirth + '\'' +
                ", distinguishingMarks='" + distinguishingMarks + '\'' +
                ", weight=" + weight +
                ", nationalities=" + nationalities +
                ", entityId='" + entityId + '\'' +
                ", eyesColorsId='" + eyesColorsId + '\'' +
                ", sexId='" + sexId + '\'' +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", forename='" + forename + '\'' +
                ", arrestWarrants=" + arrestWarrants +
                ", countryOfBirthId='" + countryOfBirthId + '\'' +
                ", hairsId=" + hairsId +
                ", name='" + name + '\'' +
                ", languagesSpokenIds=" + languagesSpokenIds +
                ", height=" + height +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}