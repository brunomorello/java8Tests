package br.com.bmo.java8tips.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private static User user;

    @BeforeAll
    static void init() {
        user = new User("Fulano", "Da Silva", LocalDate.of(1992, 8, 14));
    }

    @Test
    void getFirstName() {
        assertEquals("Fulano", user.getFirstName(), "First name must be equals");
    }

    @Test
    void getLastName() {
        assertEquals("Da Silva", user.getLastName(), "Last name must be equals");
    }

    @Test
    void getBirthDate() {
        assertEquals(LocalDate.of(1992, 8, 14), user.getBirthDate(), "Birthdate must be equals");
    }
}