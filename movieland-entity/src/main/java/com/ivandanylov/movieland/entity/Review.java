package com.ivandanylov.movieland.entity;

import java.util.Objects;

public class Review {
    private int id;
    private User user;
    private String text;

    public Review() {
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", user=" + user +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Review review = (Review) obj;

        return id == review.id &&
                user.equals(review.user) &&
                text.equals(review.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, text);
    }

    public static class Builder {
        private Review review;

        public Builder() {
            review = new Review();
        }
        public Review build() {
            return review;
        }

        public Builder id(int value) {
            review.id = value;

            return this;
        }

        public Builder user(User value) {
            review.user = value;

            return this;
        }

        public Builder text(String value) {
            review.text = value;

            return this;
        }
    }
}
