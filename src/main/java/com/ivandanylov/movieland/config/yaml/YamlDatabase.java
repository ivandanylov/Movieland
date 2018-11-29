package com.ivandanylov.movieland.config.yaml;

public class YamlDatabase {
    private YamlProperty database;

    public YamlProperty getDatabase() {
        return database;
    }

    public void setDatabase(YamlProperty database) {
        this.database = database;
    }

    @Override
    public String toString() {
        return "YamlDatabase{" +
                "database=" + database +
                '}';
    }
}
