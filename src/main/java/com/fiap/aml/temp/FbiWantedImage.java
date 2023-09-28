package com.fiap.aml.temp;

public class FbiWantedImage {
    private String original;
    private String thumb;
    private String large;
    private String caption;

    public FbiWantedImage() {

    }

    public FbiWantedImage(String original, String thumb, String large, String caption) {
        this.original = original;
        this.thumb = thumb;
        this.large = large;
        this.caption = caption;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}