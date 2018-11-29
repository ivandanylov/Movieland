package com.ivandanylov.movieland.config.yaml;

public class YamlTestMovieland {
    private YamlTestMovie movieland;

    public YamlTestMovie getMovieland() {
        return movieland;
    }

    public void setMovieland(YamlTestMovie movieland) {
        this.movieland = movieland;
    }

    @Override
    public String toString() {
        return "YamlTestMovieland{" +
                "movieland=" + movieland +
                '}';
    }
}
