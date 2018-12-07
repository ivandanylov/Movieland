package com.ivandanylov.movieland.entity;

public class Movie {
    private int id;
    private String nameRussian;
    private String nameNative;
    private int yearOfRelease;
    private double price;
    private double rating;
    private String picturePath;

    public Movie() {}

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

    public static class Builder {
        private int id;
        private String nameRussian;
        private String nameNative;
        private int yearOfRelease;
        private double price;
        private double rating;
        private String picturePath;

        public Movie build() {
            Movie movie = new Movie();
            movie.id = id;
            movie.nameRussian = nameRussian;
            movie.nameNative = nameNative;
            movie.yearOfRelease = yearOfRelease;
            movie.price = price;
            movie.rating = rating;
            movie.picturePath = picturePath;

            return movie;
        }

        public Builder id(int value) {
            this.id = value;

            return this;
        }

        public Builder nameRussian(String value) {
            this.nameRussian = value;

            return this;
        }

        public Builder nameNative(String value) {
            this.nameNative = value;

            return this;
        }

        public Builder yearOfRelease(int value) {
            this.yearOfRelease = value;

            return this;
        }

        public Builder price(double value) {
            this.price = value;

            return this;
        }

        public Builder rating(double value) {
            this.rating = value;

            return this;
        }

        public Builder picturePath(String value) {
            this.picturePath = value;

            return this;
        }
    }
}