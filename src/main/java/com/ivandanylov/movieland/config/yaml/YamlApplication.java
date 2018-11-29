package com.ivandanylov.movieland.config.yaml;

public class YamlApplication {
    private YamlDatabase application;

    public YamlDatabase getApplication() {
        return application;
    }

    public void setApplication(YamlDatabase application) {
        this.application = application;
    }

    @Override
    public String toString() {
        return "YamlApplication{" +
                "application=" + application +
                '}';
    }
}
