package com.trung.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author trung
 * @version 1.0
 * @since 9/15/2020
 */
class UserTest {
    User user;

    @BeforeEach
    void setup() {
        user = new User(0, "fullName");
    }

    //    @BeforeAll
    @Test
    void getId() {
        assertEquals(user.getId(), 0);
    }

    @Test
    void setId() {
        int id = 10;
        user.setId(id);
        assertEquals(user.getId(), 10);
    }

    @Test
    void getFullName() {
        assertEquals(user.getFullName(), "fullName");

    }

    @Test
    void setFullName() {
        String fullName = "Nguyen Van Trung";
        user.setFullName(fullName);
        assertEquals(user.getFullName(), fullName);
    }

    @Test
    void testToString() {
        String result = user.toString();
        assertEquals("|              0              |           fullName          |", result);
    }

    @Test
    void testGetHeaders() {
        String result = User.getHeaders();
        assertEquals("|              id             |           fullName          |", result);
    }
}