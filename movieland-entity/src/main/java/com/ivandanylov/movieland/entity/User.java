package com.ivandanylov.movieland.entity;

import java.util.Objects;

public class User {
    private int id;
    private String nickname;

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
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

        User user = (User) obj;

        return id == user.id &&
                nickname.equals(user.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickname);
    }

    public static class Builder {
        private User user;

        public Builder() {
            user = new User();
        }

        public User build() {
            return user;
        }

        public Builder id(int value) {
            user.id = value;

            return this;
        }

        public Builder nickname(String value) {
            user.nickname = value;

            return this;
        }
    }
}
