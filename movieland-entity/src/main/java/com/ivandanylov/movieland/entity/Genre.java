package com.ivandanylov.movieland.entity;

import java.util.Objects;

public class Genre {
    private int id;
    private String name;

    public Genre() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Genre)) {
            return false;
        }

        Genre genre = (Genre) obj;

        return id == genre.id
                && Objects.equals(name, genre.name);
    }

    public static class Builder {
        private Genre genre;

        public Builder() {
            genre = new Genre();
        }

        public Genre build() {
            return genre;
        }

        public Builder id(int value) {
            genre.id = value;

            return this;
        }

        public Builder name(String value) {
            genre.name = value;

            return this;
        }
    }
}
