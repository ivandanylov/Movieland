package com.ivandanylov.movieland.request.parameters;

import com.ivandanylov.movieland.enums.SortOrder;

import java.util.Objects;

public class MovieGetAllRequestParameters {
    private String fieldName;
    private SortOrder sortOrder;

    public boolean isSorted() {
        return fieldName != null && !fieldName.isEmpty();
    }

    public String getFieldName() {
        return fieldName;
    }

    public SortOrder getSortOrder() {
        return sortOrder;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MovieGetAllRequestParameters that = (MovieGetAllRequestParameters) obj;

        return Objects.equals(fieldName, that.fieldName) &&
                sortOrder == that.sortOrder;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldName, sortOrder);
    }

    @Override
    public String toString() {
        return "MovieGetAllRequestParameters{" +
                "fieldName='" + fieldName + '\'' +
                ", sortOrder=" + sortOrder +
                '}';
    }

    public static class Builder {
        private MovieGetAllRequestParameters movieGetAllRequestParameters;

        public Builder() {
            movieGetAllRequestParameters = new MovieGetAllRequestParameters();
        }

        public MovieGetAllRequestParameters build() {
            return movieGetAllRequestParameters;
        }

        public Builder fieldName(String value) {
            movieGetAllRequestParameters.fieldName = value.toLowerCase();

            return this;
        }

        public Builder sortOrder(String value) {
            movieGetAllRequestParameters.sortOrder = SortOrder.getSortOrder(value);

            return this;
        }
    }
}
