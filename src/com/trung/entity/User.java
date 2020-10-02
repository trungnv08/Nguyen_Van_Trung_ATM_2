package com.trung.entity;

import com.trung.util.Helpers;

import java.lang.reflect.Field;

public class User {
    private int id;
    private String fullName;

    public User(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return Helpers.toCellString(String.valueOf(id), 30) + Helpers.toCellString(fullName, 30) + '|';
    }

    public static String getHeaders() {
        final StringBuilder sb = new StringBuilder();
        for (Field field : User.class.getDeclaredFields()) {
            sb.append(Helpers.toCellString(field.getName(), 30));
        }
        sb.append('|');
        return sb.toString();
    }
}
