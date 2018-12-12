package com.ivandanylov.movieland.entity;

import java.util.List;

public class Movie {
    private int id;
    private String nameRussian;
    private String nameNative;
    private int yearOfRelease;
    private String description;
    private double price;
    private double rating;
    private String picturePath;

    private List<Country> countries;
    private List<Genre> genres;
    private List<Review> reviews;

    public Movie() {}

    public int getId() {
        return id;
    }

    public String getNameRussian() {
        return nameRussian;
    }

    public String getNameNative() {
        return nameNative;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", nameRussian='" + nameRussian + '\'' +
                ", nameNative='" + nameNative + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", picturePath='" + picturePath + '\'' +
                ", countries=" + countries +
                ", genres=" + genres +
                ", reviews=" + reviews +
                '}';
    }

    public static class Builder {
        private Movie movie;

        public Builder() {
            movie = new Movie();
        }

        public Movie build() {
            return movie;
        }

        public Builder id(int value) {
            movie.id = value;

            return this;
        }

        public Builder nameRussian(String value) {
            movie.nameRussian = value;

            return this;
        }

        public Builder nameNative(String value) {
            movie.nameNative = value;

            return this;
        }

        public Builder yearOfRelease(int value) {
            movie.yearOfRelease = value;

            return this;
        }

        public Builder description(String value) {
            movie.description = value;

            return this;
        }

        public Builder price(double value) {
            movie.price = value;

            return this;
        }

        public Builder rating(double value) {
            movie.rating = value;

            return this;
        }

        public Builder picturePath(String value) {
            movie.picturePath = value;

            return this;
        }

        public Builder countries(List<Country> value) {
            movie.countries = value;

            return this;
        }

        public Builder genres(List<Genre> value) {
            movie.genres = value;

            return this;
        }

        public Builder reviews(List<Review> value) {
            movie.reviews = value;

            return this;
        }
    }
}