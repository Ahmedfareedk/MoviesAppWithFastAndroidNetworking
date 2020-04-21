package com.example.workingwithapis.model.yts_api;

public class MovieData {
    private String title;
    private String description_full;
    private String large_cover_image;
    private String genres;
    private float rating;
    private String language;

    public MovieData()
    {

    }

    public MovieData(String title, String description_full, String large_cover_image, float rating, String genres) {
        this.title = title;
        this.description_full = description_full;
        this.large_cover_image = large_cover_image;
        this.rating = rating;
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription_full() {
        return description_full;
    }

    public void setDescription_full(String description_full) {
        this.description_full = description_full;
    }


    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }


    public String getLarge_cover_image() {
        return large_cover_image;
    }

    public void setLarge_cover_image(String large_cover_image) {
        this.large_cover_image = large_cover_image;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

}
