package com.ivandanylov.movieland.entity;

public class Genre {
    private int id;
    private String name;

    public Genre() {
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
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
}
