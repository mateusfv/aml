package com.fiap.aml.temp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FbiWanted {
    @JsonProperty("hair_raw")
    private String hairRaw;
    @JsonProperty("reward_max")
    private double rewardMax;
    @JsonProperty("person_classification")
    private String personClassification;
    private String description;
    private String eyes;
    private String nationality;
    @JsonProperty("possible_countries")
    private List<String> possibleCountries;
    @JsonProperty("weight_max")
    private int weightMax;
    private String uid;
    @JsonProperty("race_raw")
    private String raceRaw;
    @JsonProperty("warning_message")
    private String warningMessage;
    private String sex;
    private List<FbiWantedImage> images;
    @JsonProperty("field_offices")
    private List<String> fieldOffices;
    private String weight;
    @JsonProperty("poster_classification")
    private String posterClassification;
    private String build;
    private List<FbiWantedCoordinates> coordinates;
    @JsonProperty("age_range")
    private String ageRange;
    @JsonProperty("scars_and_marks")
    private String scarsAndMarks;
    private String details;
    @JsonProperty("height_max")
    private int heightMax;
    private String path;
    private String caution;
    private String publication;
    private String complexion;
    private List<FbiWantedFile> files;
    private List<String> locations;
    @JsonProperty("dates_of_birth_used")
    private List<String> datesOfBirthUsed;
    private String url;
    private String remarks;
    private double rewardMin;
    private String modified;
    private String status;
    private List<String> aliases;
    @JsonProperty("height_min")
    private int heightMin;
    private List<String> occupations;
    private String title;
    @JsonProperty("legat_names")
    private List<String> legatNames;
    @JsonProperty("age_max")
    private int ageMax;
    @JsonProperty("age_min")
    private int ageMin;
    @JsonProperty("additional_information")
    private String additionalInformation;
    private String race;
    @JsonProperty("reward_text")
    private String rewardText;
    private String ncic;
    private List<String> languages;
    @JsonProperty("eyes_raw")
    private String eyesRaw;
    private List<String> subjects;
    @JsonProperty("possible_states")
    private List<String> possibleStates;
    @JsonProperty("place_of_birth")
    private String placeOfBirth;
    private String hair;
    private String suspects;
    @JsonProperty("weight_min")
    private int weightMin;

    public FbiWanted() {

    }

    public FbiWanted(String hairRaw, double rewardMax, String personClassification, String description, String eyes, String nationality, List<String> possibleCountries, int weightMax, String uid, String raceRaw, String warningMessage, String sex, List<FbiWantedImage> images, List<String> fieldOffices, String weight, String posterClassification, String build, List<FbiWantedCoordinates> coordinates, String ageRange, String scarsAndMarks, String details, int heightMax, String path, String caution, String publication, String complexion, List<FbiWantedFile> files, List<String> locations, List<String> datesOfBirthUsed, String url, String remarks, double rewardMin, String modified, String status, List<String> aliases, int heightMin, List<String> occupations, String title, List<String> legatNames, int ageMax, int ageMin, String additionalInformation, String race, String rewardText, String ncic, List<String> languages, String eyesRaw, List<String> subjects, List<String> possibleStates, String placeOfBirth, String hair, String suspects, int weightMin) {
        this.hairRaw = hairRaw;
        this.rewardMax = rewardMax;
        this.personClassification = personClassification;
        this.description = description;
        this.eyes = eyes;
        this.nationality = nationality;
        this.possibleCountries = possibleCountries;
        this.weightMax = weightMax;
        this.uid = uid;
        this.raceRaw = raceRaw;
        this.warningMessage = warningMessage;
        this.sex = sex;
        this.images = images;
        this.fieldOffices = fieldOffices;
        this.weight = weight;
        this.posterClassification = posterClassification;
        this.build = build;
        this.coordinates = coordinates;
        this.ageRange = ageRange;
        this.scarsAndMarks = scarsAndMarks;
        this.details = details;
        this.heightMax = heightMax;
        this.path = path;
        this.caution = caution;
        this.publication = publication;
        this.complexion = complexion;
        this.files = files;
        this.locations = locations;
        this.datesOfBirthUsed = datesOfBirthUsed;
        this.url = url;
        this.remarks = remarks;
        this.rewardMin = rewardMin;
        this.modified = modified;
        this.status = status;
        this.aliases = aliases;
        this.heightMin = heightMin;
        this.occupations = occupations;
        this.title = title;
        this.legatNames = legatNames;
        this.ageMax = ageMax;
        this.ageMin = ageMin;
        this.additionalInformation = additionalInformation;
        this.race = race;
        this.rewardText = rewardText;
        this.ncic = ncic;
        this.languages = languages;
        this.eyesRaw = eyesRaw;
        this.subjects = subjects;
        this.possibleStates = possibleStates;
        this.placeOfBirth = placeOfBirth;
        this.hair = hair;
        this.suspects = suspects;
        this.weightMin = weightMin;
    }

    public String getHairRaw() {
        return hairRaw;
    }

    public void setHairRaw(String hairRaw) {
        this.hairRaw = hairRaw;
    }

    public double getRewardMax() {
        return rewardMax;
    }

    public void setRewardMax(double rewardMax) {
        this.rewardMax = rewardMax;
    }

    public String getPersonClassification() {
        return personClassification;
    }

    public void setPersonClassification(String personClassification) {
        this.personClassification = personClassification;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<String> getPossibleCountries() {
        return possibleCountries;
    }

    public void setPossibleCountries(List<String> possibleCountries) {
        this.possibleCountries = possibleCountries;
    }

    public int getWeightMax() {
        return weightMax;
    }

    public void setWeightMax(int weightMax) {
        this.weightMax = weightMax;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getRaceRaw() {
        return raceRaw;
    }

    public void setRaceRaw(String raceRaw) {
        this.raceRaw = raceRaw;
    }

    public String getWarningMessage() {
        return warningMessage;
    }

    public void setWarningMessage(String warningMessage) {
        this.warningMessage = warningMessage;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<FbiWantedImage> getImages() {
        return images;
    }

    public void setImages(List<FbiWantedImage> images) {
        this.images = images;
    }

    public List<String> getFieldOffices() {
        return fieldOffices;
    }

    public void setFieldOffices(List<String> fieldOffices) {
        this.fieldOffices = fieldOffices;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPosterClassification() {
        return posterClassification;
    }

    public void setPosterClassification(String posterClassification) {
        this.posterClassification = posterClassification;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public List<FbiWantedCoordinates> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<FbiWantedCoordinates> coordinates) {
        this.coordinates = coordinates;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public String getScarsAndMarks() {
        return scarsAndMarks;
    }

    public void setScarsAndMarks(String scarsAndMarks) {
        this.scarsAndMarks = scarsAndMarks;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getHeightMax() {
        return heightMax;
    }

    public void setHeightMax(int heightMax) {
        this.heightMax = heightMax;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCaution() {
        return caution;
    }

    public void setCaution(String caution) {
        this.caution = caution;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String getComplexion() {
        return complexion;
    }

    public void setComplexion(String complexion) {
        this.complexion = complexion;
    }

    public List<FbiWantedFile> getFiles() {
        return files;
    }

    public void setFiles(List<FbiWantedFile> files) {
        this.files = files;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public List<String> getDatesOfBirthUsed() {
        return datesOfBirthUsed;
    }

    public void setDatesOfBirthUsed(List<String> datesOfBirthUsed) {
        this.datesOfBirthUsed = datesOfBirthUsed;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public double getRewardMin() {
        return rewardMin;
    }

    public void setRewardMin(double rewardMin) {
        this.rewardMin = rewardMin;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public int getHeightMin() {
        return heightMin;
    }

    public void setHeightMin(int heightMin) {
        this.heightMin = heightMin;
    }

    public List<String> getOccupations() {
        return occupations;
    }

    public void setOccupations(List<String> occupations) {
        this.occupations = occupations;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getLegatNames() {
        return legatNames;
    }

    public void setLegatNames(List<String> legatNames) {
        this.legatNames = legatNames;
    }

    public int getAgeMax() {
        return ageMax;
    }

    public void setAgeMax(int ageMax) {
        this.ageMax = ageMax;
    }

    public int getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(int ageMin) {
        this.ageMin = ageMin;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getRewardText() {
        return rewardText;
    }

    public void setRewardText(String rewardText) {
        this.rewardText = rewardText;
    }

    public String getNcic() {
        return ncic;
    }

    public void setNcic(String ncic) {
        this.ncic = ncic;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getEyesRaw() {
        return eyesRaw;
    }

    public void setEyesRaw(String eyesRaw) {
        this.eyesRaw = eyesRaw;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public List<String> getPossibleStates() {
        return possibleStates;
    }

    public void setPossibleStates(List<String> possibleStates) {
        this.possibleStates = possibleStates;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public String getSuspects() {
        return suspects;
    }

    public void setSuspects(String suspects) {
        this.suspects = suspects;
    }

    public int getWeightMin() {
        return weightMin;
    }

    public void setWeightMin(int weightMin) {
        this.weightMin = weightMin;
    }

    @Override
    public String toString() {
        return "FbiWanted{" +
                "hairRaw='" + hairRaw + '\'' +
                ", rewardMax=" + rewardMax +
                ", personClassification='" + personClassification + '\'' +
                ", description='" + description + '\'' +
                ", eyes='" + eyes + '\'' +
                ", nationality='" + nationality + '\'' +
                ", possibleCountries=" + possibleCountries +
                ", weightMax=" + weightMax +
                ", uid='" + uid + '\'' +
                ", raceRaw='" + raceRaw + '\'' +
                ", warningMessage='" + warningMessage + '\'' +
                ", sex='" + sex + '\'' +
                ", images=" + images +
                ", fieldOffices=" + fieldOffices +
                ", weight='" + weight + '\'' +
                ", posterClassification='" + posterClassification + '\'' +
                ", build='" + build + '\'' +
                ", coordinates=" + coordinates +
                ", ageRange='" + ageRange + '\'' +
                ", scarsAndMarks='" + scarsAndMarks + '\'' +
                ", details='" + details + '\'' +
                ", heightMax=" + heightMax +
                ", path='" + path + '\'' +
                ", caution='" + caution + '\'' +
                ", publication='" + publication + '\'' +
                ", complexion='" + complexion + '\'' +
                ", files=" + files +
                ", locations=" + locations +
                ", datesOfBirthUsed=" + datesOfBirthUsed +
                ", url='" + url + '\'' +
                ", remarks='" + remarks + '\'' +
                ", rewardMin=" + rewardMin +
                ", modified='" + modified + '\'' +
                ", status='" + status + '\'' +
                ", aliases=" + aliases +
                ", heightMin=" + heightMin +
                ", occupations=" + occupations +
                ", title='" + title + '\'' +
                ", legatNames=" + legatNames +
                ", ageMax=" + ageMax +
                ", ageMin=" + ageMin +
                ", additionalInformation='" + additionalInformation + '\'' +
                ", race='" + race + '\'' +
                ", rewardText='" + rewardText + '\'' +
                ", ncic='" + ncic + '\'' +
                ", languages=" + languages +
                ", eyesRaw='" + eyesRaw + '\'' +
                ", subjects=" + subjects +
                ", possibleStates=" + possibleStates +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", hair='" + hair + '\'' +
                ", suspects='" + suspects + '\'' +
                ", weightMin=" + weightMin +
                '}';
    }
}