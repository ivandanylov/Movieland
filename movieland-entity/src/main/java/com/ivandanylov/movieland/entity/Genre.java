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

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        private int id;
        private String name;

        public Genre build() {
            Genre genre = new Genre();
            genre.id = id;
            genre.name = name;

            return genre;
        }

        public Builder id(int value) {
            this.id = value;

            return this;
        }

        public Builder name(String value) {
            this.name = value;

            return this;
        }
    }
}
