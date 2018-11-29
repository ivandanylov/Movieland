package com.ivandanylov.movieland.config.yaml;

public class YamlQuery {
    private String getAllMovies;
    private String getRandomMovies;

    public String getGetAllMovies() {
        return getAllMovies;
    }

    public void setGetAllMovies(String getAllMovies) {
        this.getAllMovies = getAllMovies;
    }

    public String getGetRandomMovies() {
        return getRandomMovies;
    }

    public void setGetRandomMovies(String getRandomMovies) {
        this.getRandomMovies = getRandomMovies;
    }

    @Override
    public String toString() {
        return "YamlQuery{" +
                "getAllMovies='" + getAllMovies + '\'' +
                ", getRandomMovies='" + getRandomMovies + '\'' +
                '}';
    }
}
