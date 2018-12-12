package com.ivandanylov.movieland.entity;

import java.util.Objects;

public class Country {
    private int id;
    private String name;

    public Country() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Country country = (Country) obj;

        return id == country.id &&
                name.equals(country.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public static class Builder {
        private Country country;

        public Builder() {
            country = new Country();
        }

        public Country build() {
            return country;
        }

        public Builder id(int value) {
            country.id = value;

            return this;
        }

        public Builder name(String value) {
            country.name = value;

            return this;
        }
    }
}
