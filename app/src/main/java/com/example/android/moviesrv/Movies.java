package com.example.android.moviesrv;

import java.util.ArrayList;

/**
 * Created by dsugh on 7/11/2017.
 */

public class Movies {

    //Data Variables
    private String imageUrl;
    private String title;
    private double rating;
    private int year;
    private ArrayList<String> genre;

    //Getters and Setters


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }
}

