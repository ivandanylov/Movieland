package com.ivandanylov.movieland.config.yaml;

public class YamlTestMovie {
    private YamlTestSql movie;

    public YamlTestSql getMovie() {
        return movie;
    }

    public void setMovie(YamlTestSql movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "YamlTestMovie{" +
                "movie=" + movie +
                '}';
    }
}
