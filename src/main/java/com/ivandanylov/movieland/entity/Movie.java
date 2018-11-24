package com.ivandanylov.movieland.entity;

import java.time.LocalDate;

public class Movie {
    private int id;
    private String nameRussian;
    private String nameNative;
    private int yearOfRelease;
    private double price;
    private double rating;
    private String picturePath;

    public Movie() {}

    public Movie(int id, String nameRussian, String nameNative, int yearOfRelease, double price, double rating, String picturePath) {
        this.id = id;
        this.nameRussian = nameRussian;
        this.nameNative = nameNative;
        this.yearOfRelease = yearOfRelease;
        this.price = price;
        this.rating = rating;
        this.picturePath = picturePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameRussian() {
        return nameRussian;
    }

    public void setNameRussian(String nameRussian) {
        this.nameRussian = nameRussian;
    }

    public String getNameNative() {
        return nameNative;
    }

    public void setNameNative(String nameNative) {
        this.nameNative = nameNative;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", nameRussian='" + nameRussian + '\'' +
                ", nameNative='" + nameNative + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", price=" + price +
                ", rating=" + rating +
                ", picturePath='" + picturePath + '\'' +
                '}';
    }
}