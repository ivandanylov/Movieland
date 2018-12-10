package com.ivandanylov.movieland.enums;

public enum SortOrder {
    ASC, DESC;

    public static SortOrder getSortOrder(String value) {
        return SortOrder.valueOf(value.toUpperCase());
    }
}
