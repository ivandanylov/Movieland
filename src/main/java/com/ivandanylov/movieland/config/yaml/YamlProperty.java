package com.ivandanylov.movieland.config.yaml;

public class YamlProperty {
    private String urlEnvironmentVariableName;
    private String driverClassName;

    public String getUrlEnvironmentVariableName() {
        return urlEnvironmentVariableName;
    }

    public void setUrlEnvironmentVariableName(String urlEnvironmentVariableName) {
        this.urlEnvironmentVariableName = urlEnvironmentVariableName;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    @Override
    public String toString() {
        return "YamlProperty{" +
                "urlEnvironmentVariableName='" + urlEnvironmentVariableName + '\'' +
                ", driverClassName='" + driverClassName + '\'' +
                '}';
    }
}
