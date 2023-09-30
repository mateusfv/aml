package com.fiap.aml.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="wanted")
public class Wanted {

    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wanted_seq")
    @SequenceGenerator(name = "wanted_seq", sequenceName = "wanted_sequence", allocationSize = 1)
    private int id;

    @Column(name="name_title")
    private String nameTitle;

    @Column(name="sex")
    private String sex;

    @Column(name="race")
    private String race;

    @Column(name="hair_color")
    private String hairColor;

    @Column(name="eye_color")
    private String eyeColor;

    @Column(name="date_of_birth")
    private String dateOfBirth;

    @Column(name="place_of_birth")
    private String placeOfBirth;

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

    @Column(name="image_path")
    private String imagePath;

    @OneToMany(mappedBy = "wanted", cascade = CascadeType.ALL)
    private List<Charge> charges;

    @OneToMany(mappedBy = "wanted", cascade = CascadeType.ALL)
    private List<DateOfBirthDeclared> datesOfBirthDeclared;

    @OneToMany(mappedBy = "wanted", cascade = CascadeType.ALL)
    private List<AlternativeName> alternativeNames;

    @OneToMany(mappedBy = "wanted", cascade = CascadeType.ALL)
    private List<Occupation> occupations;

    @OneToMany(mappedBy = "wanted", cascade = CascadeType.ALL)
    private List<Detail> details;

    @OneToMany(mappedBy = "wanted", cascade = CascadeType.ALL)
    private List<PossibleLocation> possibleLocations;


    @ManyToMany
    @JoinTable(
            name = "wanted_nationality",
            joinColumns = @JoinColumn(name = "wanted_id"),
            inverseJoinColumns = @JoinColumn(name = "nationality_id")
    )
    private Set<Nationality> nationalities = new HashSet<>();


    @ManyToMany
    @JoinTable(
            name = "wanted_language_spoken",
            joinColumns = @JoinColumn(name = "wanted_id"),
            inverseJoinColumns = @JoinColumn(name = "language_spoken_id")
    )
    private Set<LanguageSpoken> languagesSpoken = new HashSet<>();

    @OneToMany(mappedBy = "wanted", cascade = CascadeType.ALL)
    private List<IdentityNumberUsed> identityNumbersUsed;

    // Constructors
    public Wanted() {

    }

    public Wanted(String nameTitle, String sex, String race, String hairColor, String eyeColor, String dateOfBirth, String placeOfBirth, String fbiId, String fbiUrl, String interpolId, String interpolUrl, String ncic, String imagePath, List<Charge> charges, List<DateOfBirthDeclared> datesOfBirthDeclared, List<AlternativeName> alternativeNames, List<Occupation> occupations, List<Detail> details, List<PossibleLocation> possibleLocations, Set<Nationality> nationalities, Set<LanguageSpoken> languagesSpoken, List<IdentityNumberUsed> identityNumbersUsed) {
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
        this.datesOfBirthDeclared = datesOfBirthDeclared;
        this.alternativeNames = alternativeNames;
        this.occupations = occupations;
        this.details = details;
        this.possibleLocations = possibleLocations;
        this.nationalities = nationalities;
        this.languagesSpoken = languagesSpoken;
        this.identityNumbersUsed = identityNumbersUsed;
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

    public List<Charge> getCharges() {
        return charges;
    }

    public void setCharges(List<Charge> charges) {
        this.charges = charges;
    }

    public List<DateOfBirthDeclared> getDatesOfBirthDeclared() {
        return datesOfBirthDeclared;
    }

    public void setDatesOfBirthDeclared(List<DateOfBirthDeclared> datesOfBirthDeclared) {
        this.datesOfBirthDeclared = datesOfBirthDeclared;
    }

    public List<AlternativeName> getAlternativeNames() {
        return alternativeNames;
    }

    public void setAlternativeNames(List<AlternativeName> alternativeNames) {
        this.alternativeNames = alternativeNames;
    }

    public List<Occupation> getOccupations() {
        return occupations;
    }

    public void setOccupations(List<Occupation> occupations) {
        this.occupations = occupations;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    public List<PossibleLocation> getPossibleLocations() {
        return possibleLocations;
    }

    public void setPossibleLocations(List<PossibleLocation> possibleLocations) {
        this.possibleLocations = possibleLocations;
    }

    public Set<Nationality> getNationalities() {
        return nationalities;
    }

    public void setNationalities(Set<Nationality> nationalities) {
        this.nationalities = nationalities;
    }

    public Set<LanguageSpoken> getLanguagesSpoken() {
        return languagesSpoken;
    }

    public void setLanguagesSpoken(Set<LanguageSpoken> languagesSpoken) {
        this.languagesSpoken = languagesSpoken;
    }

    public List<IdentityNumberUsed> getIdentityNumbersUsed() {
        return identityNumbersUsed;
    }

    public void setIdentityNumbersUsed(List<IdentityNumberUsed> identityNumbersUsed) {
        this.identityNumbersUsed = identityNumbersUsed;
    }

    // toString()

    @Override
    public String toString() {
        return "Wanted{" +
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
                ", datesOfBirthDeclared=" + datesOfBirthDeclared +
                ", alternativeNames=" + alternativeNames +
                ", occupations=" + occupations +
                ", details=" + details +
                ", possibleLocations=" + possibleLocations +
                ", nationalities=" + nationalities +
                ", languagesSpoken=" + languagesSpoken +
                ", identityNumbersUsed=" + identityNumbersUsed +
                '}';
    }
}