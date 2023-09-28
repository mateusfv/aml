package com.fiap.aml.entity;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="wanted")
public class Wanted {

    // fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="full_name")
    private String fullName;

    @Column(name="sex")
    private String sex;

    @Column(name="race")
    private String race;

    @Column(name="alternative_names")
    private List<String> alternativeNames;

    @Column(name="hair_color")
    private String hairColor;

    @Column(name="eye_color")
    private String eyeColor;

    @Column(name="date_of_birth")
    private Date dateOfBirth;

    @Column(name="age_range")
    private String ageRange;

    @Column(name="dates_of_birth_declared")
    private List<String> datesOfBirthDeclared;

    @Column(name="place_of_birth")
    private String placeOfBirth;

    @Column(name="country_of_birth")
    private String countryOfBirth;

    @Column(name="charges")
    private List<String> charges;

    @Column(name="nationalities")
    private List<String> nationalities;

    @Column(name="languages_spoken")
    private List<String> languagesSpoken;

    @Column(name="occupations")
    private List<String> occupations;

    @Column(name="possible_locations")
    private List<String> possibleLocations;

    @Column(name="distinguishing_marks")
    private List<String> distinguishingMarks;

    @Column(name="fbi_id")
    private String fbiId;

    @Column(name="fbi_url")
    private String fbiUrl;

    @Column(name="interpol_id")
    private String interpolId;

    @Column(name="interpol_url")
    private String interpolUrl;

    @Column(name="ncic")
    private String ncic;

    @Column(name="suspects")
    private List<String> suspects;

    @Column(name="details")
    private List<String> details;

    @Column(name="image_path")
    private String imagePath;

    // constructors
    public Wanted() {

    }

    public Wanted(String fullName, String sex, String race, List<String> alternativeNames, String hairColor, String eyeColor, Date dateOfBirth, String ageRange, List<String> datesOfBirthDeclared, String placeOfBirth, String countryOfBirth, List<String> charges, List<String> nationalities, List<String> languagesSpoken, List<String> occupations, List<String> possibleLocations, List<String> distinguishingMarks, String fbiId, String fbiUrl, String interpolId, String interpolUrl, String ncic, List<String> suspects, List<String> details, String imagePath) {
        this.fullName = fullName;
        this.sex = sex;
        this.race = race;
        this.alternativeNames = alternativeNames;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.dateOfBirth = dateOfBirth;
        this.ageRange = ageRange;
        this.datesOfBirthDeclared = datesOfBirthDeclared;
        this.placeOfBirth = placeOfBirth;
        this.countryOfBirth = countryOfBirth;
        this.charges = charges;
        this.nationalities = nationalities;
        this.languagesSpoken = languagesSpoken;
        this.occupations = occupations;
        this.possibleLocations = possibleLocations;
        this.distinguishingMarks = distinguishingMarks;
        this.fbiId = fbiId;
        this.fbiUrl = fbiUrl;
        this.interpolId = interpolId;
        this.interpolUrl = interpolUrl;
        this.ncic = ncic;
        this.suspects = suspects;
        this.details = details;
        this.imagePath = imagePath;
    }

    // getters & setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public List<String> getAlternativeNames() {
        return alternativeNames;
    }

    public void setAlternativeNames(List<String> alternativeNames) {
        this.alternativeNames = alternativeNames;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public List<String> getDatesOfBirthDeclared() {
        return datesOfBirthDeclared;
    }

    public void setDatesOfBirthDeclared(List<String> datesOfBirthDeclared) {
        this.datesOfBirthDeclared = datesOfBirthDeclared;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public List<String> getCharges() {
        return charges;
    }

    public void setCharges(List<String> charges) {
        this.charges = charges;
    }

    public List<String> getNationalities() {
        return nationalities;
    }

    public void setNationalities(List<String> nationalities) {
        this.nationalities = nationalities;
    }

    public List<String> getLanguagesSpoken() {
        return languagesSpoken;
    }

    public void setLanguagesSpoken(List<String> languagesSpoken) {
        this.languagesSpoken = languagesSpoken;
    }

    public List<String> getOccupations() {
        return occupations;
    }

    public void setOccupations(List<String> occupations) {
        this.occupations = occupations;
    }

    public List<String> getPossibleLocations() {
        return possibleLocations;
    }

    public void setPossibleLocations(List<String> possibleLocations) {
        this.possibleLocations = possibleLocations;
    }

    public List<String> getDistinguishingMarks() {
        return distinguishingMarks;
    }

    public void setDistinguishingMarks(List<String> distinguishingMarks) {
        this.distinguishingMarks = distinguishingMarks;
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

    public List<String> getSuspects() {
        return suspects;
    }

    public void setSuspects(List<String> suspects) {
        this.suspects = suspects;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImage(String imagePath) {
        this.imagePath = imagePath;
    }

    // toString()

    @Override
    public String toString() {
        return "Wanted{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", sex='" + sex + '\'' +
                ", race='" + race + '\'' +
                ", alternativeNames=" + alternativeNames +
                ", hairColor='" + hairColor + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", ageRange='" + ageRange + '\'' +
                ", datesOfBirthDeclared=" + datesOfBirthDeclared +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", countryOfBirth='" + countryOfBirth + '\'' +
                ", charges=" + charges +
                ", nationalities=" + nationalities +
                ", languagesSpoken=" + languagesSpoken +
                ", occupations=" + occupations +
                ", possibleLocations=" + possibleLocations +
                ", distinguishingMarks=" + distinguishingMarks +
                ", fbiId='" + fbiId + '\'' +
                ", fbiUrl='" + fbiUrl + '\'' +
                ", interpolId='" + interpolId + '\'' +
                ", interpolUrl='" + interpolUrl + '\'' +
                ", ncic='" + ncic + '\'' +
                ", suspects=" + suspects +
                ", details=" + details +
                ", image=" + imagePath +
                '}';
    }
}